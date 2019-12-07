package com.github.njupt.campus.controller;

import com.github.njupt.campus.service.StudentService;
import com.github.njupt.common.pojo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Controller
@RequestMapping("/eas")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    public Map<String, Object> getAllStudents() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Student> students = studentService.listStudents();
        if (students != null) {
            modelMap.put("students", students);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("students", null);
        }
        return modelMap;

    }

    @RequestMapping(value = "/students/{stuId}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    public Map<String, Object> getStudentByStuId(@PathVariable Integer stuId) {
        Map<String, Object> modelMap = new HashMap<>();
        Student student = studentService.getStudentByStuId(stuId);
        if (student == null) {
            modelMap.put("state", false);
            modelMap.put("student", null);
        } else {
            modelMap.put("state", true);
            modelMap.put("student", student);
        }
        return modelMap;
    }

    @PostMapping(value = "/students")
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    public Map<String, Object> addStudent(@RequestBody Student student) {
        Map<String, Object> modelMap = new HashMap<>();
        if (studentService.insertStudent(student) > 0) {
            modelMap.put("state", true);
            modelMap.put("student", student);
        } else {
            modelMap.put("state", false);
            modelMap.put("student", null);
        }
        return modelMap;
    }
}
