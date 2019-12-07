package com.github.njupt.account.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoginAspect {
    @Pointcut("execution(* com.github.njupt.account.controller.AccountController.login(..))")
    public void login() {
    }

    @Before("login()")
    public void before() {
    }
}
