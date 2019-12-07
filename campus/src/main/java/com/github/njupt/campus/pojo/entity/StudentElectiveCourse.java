package com.github.njupt.campus.pojo.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 13:43
 * @Description:
 */
@Data
public class StudentElectiveCourse {
    private String id;
    private String courseId;
    private Integer stuId;
    private Timestamp createdTime;
    private String note;
}
