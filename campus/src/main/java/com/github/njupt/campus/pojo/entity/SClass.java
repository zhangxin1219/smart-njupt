package com.github.njupt.campus.pojo.entity;

import com.github.njupt.common.pojo.entity.Student;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Data
public class SClass {
    private String university;
    private String school;
    private Integer classId;
    private List<Student> students;
    private Timestamp createTime;
    private Timestamp updateTime;
}
