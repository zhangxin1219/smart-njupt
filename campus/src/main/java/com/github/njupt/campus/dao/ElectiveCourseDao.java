package com.github.njupt.campus.dao;

import com.github.njupt.campus.pojo.entity.ElectiveCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 11:13
 * @Description:
 */
@Mapper
@Component
public interface ElectiveCourseDao {
    ElectiveCourse getElectiveCourseByCourseId(String courseId);

    List<ElectiveCourse> listElectiveCourses();

    int insertElectiveCourse(ElectiveCourse electiveCourse);

    int increaseStudentNumByCourseId(String courseId);
}
