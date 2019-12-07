package com.github.njupt.account.service;

import com.github.njupt.common.pojo.entity.Student;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/1 15:11
 * @Description:
 */
public interface AccountService {
    boolean login(Integer stuId, String password);

    boolean register(Student student);

    boolean isAccountExist(Integer stuId);
}
