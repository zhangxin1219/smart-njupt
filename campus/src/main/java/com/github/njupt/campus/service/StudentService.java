package com.github.njupt.campus.service;

import com.github.njupt.common.pojo.entity.Student;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
public interface StudentService {
    Student getStudentByStuId(Integer stuId);

    List<Student> listStudents();

    int deleteStudentByStuId(Integer stuId);

    int updateStudent(Student student);

    int insertStudent(Student student);
}
