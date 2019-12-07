package com.github.njupt.zuul.token.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.njupt.zuul.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/7 14:03
 * @Description:
 */
@Component("redisTokenService")
public class RedisTokenServiceImpl implements TokenService {
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    @Resource(name = "jwtTokenService")
    private TokenService jwtTokenService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String createToken(String username) {
        String token = jwtTokenService.createToken(username);
        stringRedisTemplate.opsForValue().set(username + ".token", token, EXPIRE_TIME, TimeUnit.MILLISECONDS);
        return token;
    }

    @Override
    public boolean verifyToken(String username, String token) {
        String tokenFromRedis = stringRedisTemplate.opsForValue().get(username + ".token");
        if (tokenFromRedis == null)
            return false;
        return token.equals(tokenFromRedis);
    }

    @Override
    public String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
