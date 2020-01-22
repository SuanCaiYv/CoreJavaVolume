package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests
{

    @Test
    void contextLoads()
    {
        String str = "qwer,asdf,zxcv,,,,,";
        String[] strings = str.split(",");
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
