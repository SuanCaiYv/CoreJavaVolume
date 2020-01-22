package com.example.test.tools;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午5:46
 */
@Component
public class Tool
{
    public static String getUuid()
    {
        return UUID.randomUUID().toString();
    }
}
