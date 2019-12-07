package com.github.njupt.captcha;

import java.awt.image.BufferedImage;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/7 09:39
 * @Description:
 */
public interface CaptchaService {
    CaptchaDTO createCaptcha(String username);

    BufferedImage createCaptchaImage(String username);

    byte[] createCaptchaBytes(String username);

    boolean checkCaptcha(String username, String captchaReceived);
}
