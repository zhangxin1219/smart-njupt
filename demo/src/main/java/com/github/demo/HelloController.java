package com.github.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/5 13:57
 * @Description:
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello, springboot.";
    }
}
