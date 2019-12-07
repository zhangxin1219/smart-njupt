package com.github.njupt.captcha;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/1 13:13
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CaptchaServiceTest {
    @Autowired
    private CaptchaService captchaService;

    @Test
    void test() {
        String username = "zhangxin";
        CaptchaDTO captchaDTO = captchaService.createCaptcha(username);
        String captchaText = captchaDTO.getCaptchaText();
        if (captchaService.checkCaptcha(username, captchaText)) {
            log.info("图形验证码匹配成功");
        } else {
            log.info("图形验证码匹配失败");
        }
    }
}
