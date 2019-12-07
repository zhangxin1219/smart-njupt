package com.github.njupt.campus.dao;

import com.github.njupt.campus.pojo.entity.StudentElectiveCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 13:50
 * @Description:
 */
@Mapper
@Component
public interface StudentElectiveCourseDao {
    StudentElectiveCourse getStudentElectiveCourseBuId(String id);

    List<StudentElectiveCourse> listStudentElectiveCourses();

    int insertStudentElectiveCourse(StudentElectiveCourse studentElectiveCourse);
}
