package com.github.njupt.account.aspect;

import com.github.njupt.account.dto.RegisterInfoDTO;
import com.github.njupt.account.service.CaptchaService;
import com.github.njupt.common.pojo.dto.ResponseMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/1 15:57
 * @Description:
 */
@Slf4j
@Aspect
@Component
public class RegisterAspect {
    @Autowired
    private CaptchaService captchaService;

    @Pointcut("execution(* com.github.njupt.account.controller.AccountController.register(..))")
    public void register() {
    }

    @Before("register()")
    public void before() {
    }

    @After("register()")
    public void after() {
    }

    @Around("register()" + "&&args(registerInfoDTO)")
    public ResponseMsgDTO around(ProceedingJoinPoint point, RegisterInfoDTO registerInfoDTO) {
        Integer stuId = registerInfoDTO.getStuId();
        String captchaReceived = registerInfoDTO.getCaptchaText();
        log.info("客户端" + stuId + "请求验证" + captchaReceived + "正确性");
        if (captchaService.isCaptchaValid(stuId.toString(), captchaReceived)) {
            ResponseMsgDTO responseMsgDTO = new ResponseMsgDTO(0, "", null);
            try {
                responseMsgDTO = (ResponseMsgDTO) point.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return responseMsgDTO;
        } else {
            return new ResponseMsgDTO(0, "注册过程图形验证码错误", null);
        }
    }

    @AfterReturning("register()")
    public void afterReturning() {
    }

    @AfterThrowing("register()")
    public void afterThrowing() {
    }
}
