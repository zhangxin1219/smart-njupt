package com.github.njupt.account.service.impl;

import com.github.njupt.account.service.CaptchaRibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/7 09:43
 * @Description:
 */
@Slf4j
@Service
public class CaptchaRibbonServiceImpl implements CaptchaRibbonService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "createCaptchaBytesError")
    @Override
    public byte[] createCaptchaBytes(String username) {
        return restTemplate.getForObject(
                "http://captcha-server/captcha/" + username + "/bytes", byte[].class);
    }

    @HystrixCommand(fallbackMethod = "checkCaptchaValidityError")
    @Override
    public String checkCaptchaValidity(String username, String captchaReceived) {
        // restTemplate前有@LoadBalancing,以http://captcha-server/开始
        // restTemplate前无@LoadBalancing,以http://127.0.0.1:8082/开始
        return restTemplate.getForObject(
                "http://captcha-server/captcha/" + username + "/" + captchaReceived, String.class);
    }

    public byte[] createCaptchaBytesError(String username) {
        byte[] bytes = new byte[10];
        for (int i = 0; i < 10; i++) {
            bytes[i] = 1;
        }
        return bytes;
    }

    public String checkCaptchaValidityError(String username, String captchaReceived) {
        return "fail";
    }
}
