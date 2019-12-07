package com.github.njupt.campus.service;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/20 14:48
 * @Description:
 */
public interface CampusCardService {
    int getBalance(Integer stuId);

    boolean createCampusCard(Integer stuId);
}
