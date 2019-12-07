package com.github.njupt.captcha;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.image.BufferedImage;

@Data
@AllArgsConstructor
public class CaptchaDTO {
    private String captchaText;
    private BufferedImage captchaImage;
}
