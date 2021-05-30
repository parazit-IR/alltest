package com.example.alltest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class AlltestApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        System.out.println("---------===----------");
        System.out.println(applicationContext.getDisplayName());
        System.out.println(applicationContext.getId());
        System.out.println(applicationContext.getParent());
        System.out.println(applicationContext.getStartupDate());
    }

}
