package com.github.njupt.campus.pojo.entity;

import lombok.Data;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 10:43
 * @Description:
 */
@Data
public class ElectiveCourse {
    private String courseId;
    private String courseName;
    private Integer teacherId;
    private Integer credit;
    private Integer studentTotal;
    private Integer studentNum;
    private String note;
}
