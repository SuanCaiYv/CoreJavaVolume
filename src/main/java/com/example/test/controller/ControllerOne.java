package com.example.test.controller;

import com.example.test.dao.StudentMapper;
import com.example.test.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/1/18 下午11:08
 */
@Controller
public class ControllerOne
{
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping(value = "/index")
    public String f1()
    {
        return "index";
    }
    @RequestMapping(value = "no_sign_up")
    public String f2()
    {
        return "sign_up";
    }
    @RequestMapping(value = "sign_up", method = RequestMethod.POST)
    public String f3(Student student, @RequestParam(name = "rePassword") String rePasswoed, Model model)
    {
        if (student.getPassword().equals(rePasswoed)) {
            studentMapper.insert(student);
            return "index";
        }
        else {
            return "re_password_error";
        }
    }
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public String f4(Model model)
    {
        List<Student> list = studentMapper.getAll();
        StringBuilder str = new StringBuilder();
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            str.append(iterator.next());
            iterator.remove();
        }
        model.addAttribute("list", str.toString());
        return "all_student";
    }
    @RequestMapping(value = "/password/{id}", method = RequestMethod.GET)
    public String f5(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("password", studentMapper.getPassword(id));
        return "student_passwd";
    }
}

