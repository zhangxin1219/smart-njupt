package com.github.njupt.campus.controller;

import com.github.njupt.campus.pojo.entity.SClass;
import com.github.njupt.campus.service.SClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Controller
@RequestMapping("/eas")
public class SClassController {
    @Autowired
    private SClassService sClassService;

    @RequestMapping(value = "/classes/{classId}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)

    public Map<String, Object> getClassByClassId(@PathVariable Integer classId) {
        Map<String, Object> modelMap = new HashMap<>();
        SClass schoolClass = sClassService.getSClassByClassId(classId);
        if (schoolClass == null)
            modelMap.put("state", false);
        else
            modelMap.put("state", true);
        modelMap.put("class", schoolClass);
        return modelMap;
    }
}
