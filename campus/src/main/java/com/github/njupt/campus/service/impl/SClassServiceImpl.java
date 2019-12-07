package com.github.njupt.campus.service.impl;


import com.github.njupt.campus.dao.SClassDao;
import com.github.njupt.campus.pojo.entity.SClass;
import com.github.njupt.campus.service.SClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/7/26 16:39
 * @Description:
 */
@Service
public class SClassServiceImpl implements SClassService {
    @Autowired
    private SClassDao sClassDao;

    @Override
    public SClass getSClassByClassId(Integer classId) {
        return sClassDao.getSClassByClassId(classId);
    }
}
