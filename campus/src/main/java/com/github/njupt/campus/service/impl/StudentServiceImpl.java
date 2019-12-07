package com.github.njupt.campus.service.impl;

import com.github.njupt.campus.service.StudentService;
import com.github.njupt.common.dao.StudentDao;
import com.github.njupt.common.pojo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getStudentByStuId(Integer stuId) {
        return studentDao.getStudentByStuId(stuId);
    }

    @Override
    public List<Student> listStudents() {
        return studentDao.listStudents();
    }

    @Override
    public int deleteStudentByStuId(Integer stuId) {
        return studentDao.deleteStudentByStuId(stuId);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertStudent(Student student) {
        int x = studentDao.insertStudent(student);
        return x;
    }
}
