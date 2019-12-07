package com.github.njupt.campus.pojo.entity;

import com.github.njupt.campus.pojo.enums.StudentTypeEnum;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Data
public class CampusCard {
    private Long cardId;
    private Integer stuId;
    private String realName;
    private String mobilePhone;
    private StudentTypeEnum type;
    private Integer balance;
    private Timestamp createTime;
    private Timestamp updateTime;
}
