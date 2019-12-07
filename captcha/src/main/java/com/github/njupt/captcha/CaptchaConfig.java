package com.github.njupt.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/6 17:29
 * @Description:
 */
@Component
public class CaptchaConfig {
    @Bean(name = "captchaProducer")
    public DefaultKaptcha getDefaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty("kaptcha.border", "no");
        properties.setProperty("kaptcha.border.thickness", "5");
        // 图片宽
        properties.setProperty("kaptcha.image.width", "320");
        // 图片高
        properties.setProperty("kaptcha.image.height", "180");
        properties.setProperty("kaptcha.producer.impl", "com.google.code.kaptcha.impl.DefaultKaptcha");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.DefaultTextCreator");
        properties.setProperty("kaptcha.textproducer.char.string", "abcde2345678gfynmnpwx");
        properties.setProperty("kaptcha.textproducer.font.size", "90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        properties.setProperty("kaptcha.background.impl", "com.google.code.kaptcha.impl.DefaultBackground");
        properties.setProperty("kaptcha.background.clear.to", "white");
        properties.setProperty("kaptcha.word.impl", "com.google.code.kaptcha.text.impl.DefaultWordRenderer");
        properties.setProperty("kaptcha.session.key", "KAPTCHA_SESSION_KEY");
        properties.setProperty("kaptcha.session.date", "KAPTCHA_SESSION_DATE");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
