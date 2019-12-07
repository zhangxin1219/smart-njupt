package com.github.njupt.campus.dao;

import com.github.njupt.campus.pojo.entity.SClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Mapper
@Component
public interface SClassDao {
    SClass getSClassByClassId(Integer classId);
}
