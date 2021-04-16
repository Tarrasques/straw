package com.tarrasques.straw.api.user;

import com.tarrasques.straw.api.user.mapper.UserMapper;
import com.tarrasques.straw.commons.model.User;
import com.tarrasques.straw.api.user.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class StrawApiUserApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Test
    void getConnection() throws Exception {
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Autowired
    UserMapper mapper;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("Ran6");
        user.setPassword("tianzhdeson");
        user.setPhone("12345678910");
        int insert = mapper.insert(user);
        System.out.println(insert);
    }

    @Test
    void findUser() {
        User ranJF = mapper.findByUsername("RanJF");
        System.out.println(ranJF);
    }

    @Autowired
    IUserService service;

    @Test
    void regist() {
        User user = new User();
        user.setUsername("RanJF");
        user.setPassword("tianzhdeson");
        user.setPhone("12345678910");

    }

}
