package com.github.njupt.campus.controller;

import com.github.njupt.campus.service.CampusCardService;
import com.github.njupt.common.pojo.dto.ResponseMsgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/20 14:57
 * @Description:
 */

@RestController
@RequestMapping("/eas")
public class CampusCardController {
    @Autowired
    private CampusCardService campusCardService;

    @GetMapping("/{stuId}/balance")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseMsgDTO getBalance(@PathVariable Integer stuId) {
        int balance = campusCardService.getBalance(stuId);
        return new ResponseMsgDTO(1, "余额查询成功", balance);
    }
}
