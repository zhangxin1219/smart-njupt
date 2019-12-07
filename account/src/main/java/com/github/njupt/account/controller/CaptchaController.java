package com.github.njupt.account.controller;

import com.github.njupt.account.service.CaptchaService;
import com.github.njupt.common.pojo.dto.ResponseMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/6 16:31
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping("/account")
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    @RequestMapping(value = "/{username}/captcha/jpg", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ModelAndView createCaptcha(HttpServletResponse response,
                                      @PathVariable String username) throws Exception {
        BufferedImage captchaImage = captchaService.createCaptcha(username);
        // Set to expire far in the past.
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(captchaImage, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    @RequestMapping(value = "/{username}/captcha/{captcha}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsgDTO loginCheck(@PathVariable(value = "captcha") String captchaReceived,
                                     @PathVariable(value = "username") String username) {
        if (captchaService.isCaptchaValid(username, captchaReceived)) {
            return new ResponseMsgDTO(1, "验证码验证成功", null);
        } else {
            return new ResponseMsgDTO(0, "验证码验证失败", null);
        }
    }
}
