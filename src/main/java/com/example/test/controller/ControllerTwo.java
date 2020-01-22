package com.example.test.controller;

import com.example.test.dao.StudentMapper;
import com.example.test.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author SuanCaiYv
 * @time 2020/1/20 下午4:45
 */
@Controller
public class ControllerTwo
{
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping(value = "/login_in", method = RequestMethod.POST)
    public String f1(@RequestParam("id") Integer id, @RequestParam("password") String password, Model model)
    {
        Student student = studentMapper.getStudent(id);
        if (student == null) {
            return "ready_sign_up";
        }
        else if (!student.getPassword().equals(password)) {
            return "password_error";
        }
        else if (student.getIsCommittee() == 0) {
            model.addAttribute("student", student);
            Integer[] arrays = new Integer[10];
            for (int i = 0; i < 10; ++ i) {
                arrays[i] = i;
            }
            model.addAttribute("undo", arrays);
            model.addAttribute("done", arrays);
            return "normal_student";
        }
        else {
            model.addAttribute("student", student);
            Integer[] arrays = new Integer[10];
            for (int i = 1; i < 11; ++ i) {
                arrays[i] = i;
            }
            model.addAttribute("undo", arrays);
            model.addAttribute("done", arrays);
            model.addAttribute("task", "task");
            return "committee_student";
        }
    }
    @RequestMapping(value = "/upload")
    public String f2(@RequestParam(name = "id") Integer id, @RequestParam(name = "task") String task)
    {
        return "test";
    }
}
