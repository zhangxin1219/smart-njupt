package com.github.njupt.account.controller;

import com.github.njupt.account.dto.LoginInfoDTO;
import com.github.njupt.account.dto.RegisterInfoDTO;
import com.github.njupt.account.service.AccountService;
import com.github.njupt.account.service.TokenService;
import com.github.njupt.common.annotation.WebLog;
import com.github.njupt.common.pojo.dto.ResponseMsgDTO;
import com.github.njupt.common.pojo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/1 14:27
 * @Description:
 */
@Controller
@RequestMapping("/account")
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Resource(name = "redisTokenService")
    private TokenService tokenService;

    @PostMapping(value = "/login")
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    @WebLog(description = "登录")
    public ResponseMsgDTO login(@RequestBody LoginInfoDTO loginInfo) {
        Integer stuId = loginInfo.getStuId();
        String password = loginInfo.getPassword();
        if (accountService.login(stuId, password)) {
            String token = tokenService.createToken(stuId.toString());
            return new ResponseMsgDTO(1, "登陆成功", token);
        } else {
            return new ResponseMsgDTO(0, "登陆失败");
        }
    }

    @PostMapping(value = "/register")
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    @WebLog(description = "注册")
    public ResponseMsgDTO register(@RequestBody RegisterInfoDTO registerInfoDTO) {
        if (!accountService.isAccountExist(registerInfoDTO.getStuId())) {
            Student student = new Student();
            student.setStuId(registerInfoDTO.getStuId());
            student.setStuName(registerInfoDTO.getStuName());
            String password = registerInfoDTO.getPassword();
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            student.setPassword(md5Password);
            if (accountService.register(student)) {
                return new ResponseMsgDTO(1, "注册成功");
            } else {
                return new ResponseMsgDTO(0, "注册失败");
            }
        } else {
            return new ResponseMsgDTO(0, "账号已存在");
        }
    }
}
