package com.github.njupt.account.service.impl;

import com.github.njupt.account.service.CaptchaFeignService;
import org.springframework.stereotype.Component;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/2 14:33
 * @Description:
 */
@Component
public class CaptchaFeignServiceHystrix implements CaptchaFeignService {
    @Override
    public byte[] createCaptchaBytes(String username) {
        byte[] bytes = new byte[10];
        for (int i = 0; i < 10; i++) {
            bytes[i] = 1;
        }
        return bytes;
    }

    @Override
    public String checkCaptchaValidity(String username, String captcha) {
        return "fail";
    }

}
