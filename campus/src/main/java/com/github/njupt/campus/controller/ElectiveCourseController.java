package com.github.njupt.campus.controller;

import com.github.njupt.campus.service.ElectiveCourseService;
import com.github.njupt.common.pojo.dto.ResponseMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 14:50
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping("/eas/course/elective")
public class ElectiveCourseController {
    @Autowired
    private ElectiveCourseService electiveCourseService;

    @RequestMapping("/{courseId}/{stuId}")
    @ResponseBody
    @CrossOrigin(origins = "*",maxAge = 3600)
    public ResponseMsgDTO selectElectiveCourse(
            @PathVariable String courseId,
            @PathVariable Integer stuId) {
//        log.info("进入");
        int result = electiveCourseService.selectElectiveCourse(stuId, courseId);
        ResponseMsgDTO ResponseMsgDTO = null;
        if (result > 0) {
            ResponseMsgDTO = new ResponseMsgDTO(1, "选课成功", null);
        } else {
            ResponseMsgDTO = new ResponseMsgDTO(0, "选课失败", null);
        }
        return ResponseMsgDTO;
    }

    @GetMapping("test")
    @ResponseBody
    @CrossOrigin(origins = "*",maxAge = 3600)
    public String test(){
        log.info("你好");
        log.error("再见");
        return "String";
    }
}
