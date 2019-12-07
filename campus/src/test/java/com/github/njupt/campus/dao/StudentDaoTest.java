package com.github.njupt.campus.dao;

import com.github.njupt.common.dao.StudentDao;
import com.github.njupt.common.pojo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/7 13:28
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void test() {
        String md5Password = DigestUtils.md5DigestAsHex("123456".getBytes());
        Student student = studentDao.getStudentByStuIdAndPwd(1218094208, md5Password);
        System.out.println(student);
    }
}
