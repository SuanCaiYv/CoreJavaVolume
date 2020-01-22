package com.example.test;

import com.example.test.tools.FileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TestApplication.class, args);
        FileUtil fileUtil = new FileUtil();
        fileUtil.deleteAtFixedRate();
    }
}
