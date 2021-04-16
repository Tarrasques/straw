package com.tarrasques.straw.gateway;

import com.tarrasques.straw.gateway.security.UserDetailsServiceImpl;
import com.tarrasques.straw.gateway.service.IPermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StrawGatewayApplicationTests {

    @Autowired
    UserDetailsServiceImpl s;

    @Test
    void contextLoads() {
        System.out.println(s.loadUserByUsername("18584581526"));
    }

    @Test
    void test(){
        System.out.println("sda asd asd asd dasd ");
    }

}
