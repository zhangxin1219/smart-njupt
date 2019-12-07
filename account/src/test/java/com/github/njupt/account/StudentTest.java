package com.github.njupt.account;

import com.github.njupt.common.dao.StudentDao;
import com.github.njupt.common.pojo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/7 17:18
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void test() {
        Student student = studentDao.getStudentByStuId(1218094208);
        log.info(student.toString());
    }
}
