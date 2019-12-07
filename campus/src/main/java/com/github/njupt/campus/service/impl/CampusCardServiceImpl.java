package com.github.njupt.campus.service.impl;

import com.github.njupt.campus.dao.CampusCardDao;
import com.github.njupt.campus.dao.NetworkFeeAccountDao;
import com.github.njupt.campus.dao.WaterFeeAccountDao;
import com.github.njupt.campus.exception.TupleNotFoundException;
import com.github.njupt.campus.pojo.entity.CampusCard;
import com.github.njupt.campus.pojo.entity.NetworkFeeAccount;
import com.github.njupt.campus.pojo.entity.WaterFeeAccount;
import com.github.njupt.campus.service.CampusCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/20 14:50
 * @Description:
 */
@Service
public class CampusCardServiceImpl implements CampusCardService {
    @Autowired
    private CampusCardDao campusCardDao;
    @Autowired
    private NetworkFeeAccountDao networkFeeAccountDao;
    @Autowired
    private WaterFeeAccountDao waterFeeAccountDao;

    @Override
    @Cacheable(value = "redisCacheManager", key = "#stuId+'.balance'")
    public int getBalance(Integer stuId) {
        CampusCard campusCard = campusCardDao.getCampusCardByStuId(stuId);
        if (campusCard != null) {
            int balance = campusCard.getBalance();
            return balance;
        } else {
            throw new TupleNotFoundException();
        }
    }

    @Deprecated
    @Override
    public boolean createCampusCard(Integer stuId) {
        return false;
    }
}
