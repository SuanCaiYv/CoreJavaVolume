package com.example.test.dao;

import com.example.test.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/1/19 下午8:11
 */
@Mapper
@Component
public interface StudentMapper
{
    List<Student> getAll();
    Student getStudent(Integer id);
    String getName(Integer id);
    Integer getIsCommittee(Integer id);
    String getPassword(Integer id);
    void insert(Student student);
    String getUndo(Integer id);
    String getDone(Integer id);
    String getEmail(Integer id);
    Integer getClassRoom(Integer id);
    String getDepartment(Integer id);
    Integer getGrade(Integer id);
    Integer updatePassword(Integer id, String undo);
    void updateUndo(Integer id, String undo);
    Integer updateDone(Integer id, String done);
    Integer updateIsCommittee(Integer id);
    Integer updateName(Integer is, String name);
    List<Integer> getSameClassroom(Student student);
}
