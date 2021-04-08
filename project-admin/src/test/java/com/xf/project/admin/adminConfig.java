package com.xf.project.admin;

import com.xf.project.admin.controller.test.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xf
 * @version 1.0
 * @date 2021/3/29 15:11
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class adminConfig {
    @Autowired
    private User u;
    @Test
    public void test(){
        System.out.println(u);
    }
}
