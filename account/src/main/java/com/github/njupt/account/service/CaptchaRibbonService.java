package com.github.njupt.account.service;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/7 09:39
 * @Description: ribbon模式
 */
public interface CaptchaRibbonService {
    byte[] createCaptchaBytes(String username);

    String checkCaptchaValidity(String username, String captchaReceived);
}
