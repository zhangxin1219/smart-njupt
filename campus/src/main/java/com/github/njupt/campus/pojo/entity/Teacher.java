package com.github.njupt.campus.pojo.entity;

import com.github.njupt.campus.pojo.enums.TeacherRankEnum;
import lombok.Data;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/21 10:44
 * @Description:
 */
@Data
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    //学校
    private String university;
    //所在单位
    private String school;
    //职称
    private TeacherRankEnum rank;
    private String note;
}
