package com.github.njupt.zuul;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.njupt.zuul.token.TokenService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/4 10:26
 * @Description:
 */
@Slf4j
@Component
public class TokenFilter extends ZuulFilter {
    private static final String LOGIN_URI = "/account/login";
    private static final String REGISTER_URI = "/account/register";
    @Resource(name = "redisTokenService")
    private TokenService tokenService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        String[] splitURI = requestURI.split("/");
        if (splitURI.length >= 2 && "account".equals(splitURI[1])) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("Authorization-Token");
        Map<String, Object> result = new HashMap<>();
        HttpServletResponse response = requestContext.getResponse();
        if (token == null) {
            result.put("time", new Date());
            result.put("status", "error");
            result.put("msg", "Zuul: token is empty!");
            response.setContentType("application/json;charset=utf-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.print(
                        JSONObject.toJSONString(result,
                                SerializerFeature.PrettyFormat,
                                SerializerFeature.WriteMapNullValue,
                                SerializerFeature.WriteDateUseDateFormat)
                );
                writer.close();
                response.flushBuffer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String username = tokenService.getUsername(token);
        if (!tokenService.verifyToken(username, token)) {
            log.info("token is not valid, no!");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            result.put("time", new Date());
            result.put("status", "error");
            result.put("msg", "Zuul: token is not valid!");
            response.setContentType("application/json;charset=utf-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.print(
                        JSONObject.toJSONString(result,
                                SerializerFeature.PrettyFormat,
                                SerializerFeature.WriteMapNullValue,
                                SerializerFeature.WriteDateUseDateFormat)
                );
                writer.close();
                response.flushBuffer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            log.info("token is valid, ok!");
        }
        return null;
    }
}
