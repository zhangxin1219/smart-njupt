package com.github.njupt.account.service.impl;

import com.github.njupt.account.service.AccountService;
import com.github.njupt.common.dao.StudentDao;
import com.github.njupt.common.pojo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/8/1 15:13
 * @Description:
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean login(Integer stuId, String password) {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        Student student = studentDao.getStudentByStuIdAndPwd(stuId, md5Password);
        if (null != student)
            return true;
        else
            return false;
    }

    @Override
    public boolean register(Student student) {
        if (studentDao.insertStudent(student) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean isAccountExist(Integer stuId) {
        if (studentDao.countStudentByStuId(stuId) > 0)
            return true;
        else
            return false;
    }
}
