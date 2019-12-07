package com.github.njupt.campus.service.impl;

import com.github.njupt.campus.dao.ElectiveCourseDao;
import com.github.njupt.campus.dao.StudentElectiveCourseDao;
import com.github.njupt.campus.pojo.entity.ElectiveCourse;
import com.github.njupt.campus.pojo.entity.StudentElectiveCourse;
import com.github.njupt.campus.service.ElectiveCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 14:38
 * @Description:
 */
@Service
public class ElectiveCourseServiceImpl implements ElectiveCourseService {
    @Autowired
    private ElectiveCourseDao electiveCourseDao;
    @Autowired
    private StudentElectiveCourseDao studentElectiveCourseDao;

    @Override
    public ElectiveCourse getElectiveCourseByCourseId(String courseId) {
        return electiveCourseDao.getElectiveCourseByCourseId(courseId);
    }

    @Override
    public int selectElectiveCourse(Integer stuId, String courseId) {
        ElectiveCourse electiveCourse = electiveCourseDao.getElectiveCourseByCourseId(courseId);
        if (electiveCourse.getStudentTotal() - electiveCourse.getStudentNum() > 0) {
            electiveCourseDao.increaseStudentNumByCourseId(courseId);
            StudentElectiveCourse studentElectiveCourse = new StudentElectiveCourse();
            studentElectiveCourse.setId(courseId.substring(courseId.length() - 1) + stuId + System.currentTimeMillis() / 1000);
            studentElectiveCourse.setStuId(stuId);
            studentElectiveCourse.setCourseId(courseId);
            int result = studentElectiveCourseDao.insertStudentElectiveCourse(studentElectiveCourse);
            return result;
        }
        return 0;
    }
}
