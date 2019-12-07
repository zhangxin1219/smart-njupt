package com.github.njupt.campus.service;

import com.github.njupt.campus.pojo.entity.ElectiveCourse;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 14:32
 * @Description:
 */
public interface ElectiveCourseService {
    ElectiveCourse getElectiveCourseByCourseId(String courseId);

    int selectElectiveCourse(Integer stuId, String courseId);
}
