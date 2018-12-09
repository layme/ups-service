package com.ziroom.ups.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author
 * @create 2018-12-09 23:11
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private ApplicationMapper applicationMapper;
    @Test
    public void testSelectByPrimaryKey() {
        System.out.println(applicationMapper.selectByPrimaryKey(1));
    }
}
