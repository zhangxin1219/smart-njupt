package com.github.njupt.captcha;

import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/7 09:43
 * @Description:
 */
@Slf4j
@Service
public class CaptchaServiceImpl implements CaptchaService {
    private static final String CAPTCHA_REDIS_KEY_SUFFIX = ".captcha";
    @Autowired
    private Producer captchaProducer;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public CaptchaDTO createCaptcha(String username) {
        String captchaText = captchaProducer.createText();
        log.info(username + "验证码: " + captchaText);
        BufferedImage captchaImage = captchaProducer.createImage(captchaText);
        CaptchaDTO captchaDTO = new CaptchaDTO(captchaText, captchaImage);
        stringRedisTemplate.opsForValue().set(
                username + CAPTCHA_REDIS_KEY_SUFFIX, captchaText, 3, TimeUnit.MINUTES);
        log.info("验证码写入Redis缓存");
        return captchaDTO;
    }

    @Override
    public BufferedImage createCaptchaImage(String username) {
        CaptchaDTO captchaDTO = this.createCaptcha(username);
        return captchaDTO.getCaptchaImage();
    }

    @Override
    public byte[] createCaptchaBytes(String username) {
        BufferedImage captchaImage = this.createCaptchaImage(username);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(captchaImage, "jpg", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public boolean checkCaptcha(String username, String captchaReceived) {
        if (null == captchaReceived) {
            log.info("客户端验证码为空");
            return false;
        }
        String captchaExpected = stringRedisTemplate.opsForValue().get(username + CAPTCHA_REDIS_KEY_SUFFIX);
        log.info("验证码从Redis缓存中读取：" + captchaExpected);
        if (null == captchaExpected) {
            log.info("Redis缓存中验证码为null, 验证码过期or用户名错误");
            return false;
        } else if (!captchaExpected.equals(captchaReceived)) {
            log.info("验证码校验失败");
            return false;
        } else {
            log.info("验证码校验正确");
            return true;
        }
    }

}
