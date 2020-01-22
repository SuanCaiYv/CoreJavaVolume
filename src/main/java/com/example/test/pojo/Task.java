package com.example.test.pojo;

import org.springframework.stereotype.Component;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午4:30
 */
@Component
public class Task
{
    private String uuid;
    private String name;
    private Long lunchTime;
    private Integer id;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Long getLunchTime()
    {
        return lunchTime;
    }

    public void setLunchTime(Long lunchTime)
    {
        this.lunchTime = lunchTime;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
}
