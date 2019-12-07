package com.github.njupt.account.service;

import java.awt.image.BufferedImage;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/2 22:43
 * @Description:
 */
public interface CaptchaService {
    BufferedImage createCaptcha(String username);

    boolean isCaptchaValid(String username, String captchaReceived);

    boolean isBytesFromCaptchaServer(byte[] bytes);
}
