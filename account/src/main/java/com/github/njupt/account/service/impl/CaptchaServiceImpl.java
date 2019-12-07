package com.github.njupt.account.service.impl;

import com.github.njupt.account.service.CaptchaRibbonService;
import com.github.njupt.account.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/2 22:43
 * @Description:
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Autowired
//    private CaptchaFeignService captchaFeignService;
    private CaptchaRibbonService captchaRibbonService;

    @Override
    public BufferedImage createCaptcha(String username) {
        byte[] bytes = captchaRibbonService.createCaptchaBytes(username);
        if (isBytesFromCaptchaServer(bytes)) {

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            BufferedImage captchaImage = null;
            try {
                captchaImage = ImageIO.read(byteArrayInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return captchaImage;
        } else {
            BufferedImage errorImage = null;
            try {
                URL url = new URL("http://127.0.0.1:8081/image/captcha/error.png");
                InputStream inputStream = url.openStream();
                errorImage = ImageIO.read(inputStream);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return errorImage;
        }
    }

    @Override
    public boolean isCaptchaValid(String username, String captchaReceived) {
        String result = captchaRibbonService.checkCaptchaValidity(username, captchaReceived);
        return "success".equals(result);
    }

    @Override
    public boolean isBytesFromCaptchaServer(byte[] bytes) {
        if (bytes.length == 10 && bytes[0] == 1)
            return false;
        return true;
    }
}
