package com.github.njupt.common.dao;

import com.github.njupt.common.pojo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Mapper
@Component
public interface StudentDao {
    Student getStudentByStuId(Integer stuId);

    Student getStudentByStuIdAndPwd(@Param("stuId") Integer stuId, @Param("password") String password);

    List<Student> listStudents();

    int countStudentByStuId(Integer stuId);

    int deleteStudentByStuId(Integer stuId);

    int updateStudent(Student student);

    int insertStudent(Student student);
}
