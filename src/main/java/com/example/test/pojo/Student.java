package com.example.test.pojo;

import org.springframework.stereotype.Component;

/**
 * @author SuanCaiYv
 * @time 2020/1/19 下午7:55
 */
@Component
public class Student
{
    private Integer id;
    private String name;
    private String password;
    private Integer isCommittee;
    private String undo;
    private String done;
    private String department;
    private Integer grade;
    private Integer classroom;
    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getClassroom()
    {
        return classroom;
    }

    public void setClassroom(Integer classroom)
    {
        this.classroom = classroom;
    }

    public Integer getGrade()
    {
        return grade;
    }

    public void setGrade(Integer grade)
    {
        this.grade = grade;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDone()
    {
        return done;
    }

    public void setDone(String done)
    {
        this.done = done;
    }

    public String getUndo()
    {
        return undo;
    }

    public void setUndo(String undo)
    {
        this.undo = undo;
    }

    public Integer getIsCommittee()
    {
        return isCommittee;
    }

    public void setIsCommittee(Integer isCommittee)
    {
        this.isCommittee = isCommittee;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return id+" "+name+" "+password+" "+isCommittee+" "+undo+" "+done+
                " "+department+" "+grade+" "+classroom+" "+email;
    }
}
