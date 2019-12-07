package com.github.njupt.account.service;

import com.github.njupt.account.service.impl.CaptchaFeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/2 13:25
 * @Description: feign模式
 */
@FeignClient(value = "captcha-server"
        , fallback = CaptchaFeignServiceHystrix.class
)
public interface CaptchaFeignService {
    @RequestMapping(value = "/captcha/{username}/bytes", method = RequestMethod.GET)
    byte[] createCaptchaBytes(@PathVariable String username);

    @RequestMapping(value = "/captcha/{username}/{captcha}")
    String checkCaptchaValidity(@PathVariable String username, @PathVariable String captcha);
}
