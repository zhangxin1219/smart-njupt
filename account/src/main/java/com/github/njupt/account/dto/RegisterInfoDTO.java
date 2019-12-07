package com.github.njupt.account.dto;

import lombok.Data;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/9 10:06
 * @Description:
 */
@Data
public class RegisterInfoDTO {
    private Integer stuId;
    private String stuName;
    private String password;
    private String captchaText;
}
