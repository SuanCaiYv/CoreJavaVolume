package com.example.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午4:30
 */
@Mapper
@Component
public interface TaskMapper
{
    List<String> getTaskPathNeededDeleted(Long lunchTime);
    String getPath(String uuid);
}
