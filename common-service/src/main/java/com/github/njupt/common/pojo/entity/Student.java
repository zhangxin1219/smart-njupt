package com.github.njupt.common.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/7 17:09
 * @Description:
 */
@Data
public class Student {
    private Integer stuId;
    private String stuName;
    @JSONField(serialize = false)
    private String password;
    private Integer classId;
    private Timestamp createTime;
    private Timestamp updateTime;
}
