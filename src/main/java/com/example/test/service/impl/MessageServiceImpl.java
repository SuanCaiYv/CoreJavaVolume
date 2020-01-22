package com.example.test.service.impl;

import com.example.test.dao.StudentMapper;
import com.example.test.dao.TaskMapper;
import com.example.test.pojo.Student;
import com.example.test.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午5:35
 */
@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public String[] getUndos(Integer id)
    {
        String undo = studentMapper.getUndo(id);
        return undo.split(",");
    }

    @Override
    public String[] getDones(Integer id)
    {
        String done = studentMapper.getDone(id);
        return done.split(",");
    }

    @Override
    public HashMap<String, String> getUndoUUIDAndFileNameMap(Integer id)
    {
        HashMap<String, String> map = new HashMap<>();
        String[] undos = getUndos(id);
        for (String undo : undos) {
            map.put(undo, getFileName(undo));
        }
        return map;
    }

    @Override
    public HashMap<String, String> getDoneUUIDAndFileNameMap(Integer id)
    {
        HashMap<String, String> map = new HashMap<>();
        String[] dones = getDones(id);
        for (String done : dones) {
            map.put(done, getFileName(done));
        }
        return map;
    }

    @Override
    public String getStudentName(Integer id)
    {
        return studentMapper.getName(id);
    }

    @Override
    public String getStudentDepartment(Integer id)
    {
        return studentMapper.getDepartment(id);
    }

    @Override
    public Integer getStudentGrade(Integer id)
    {
        return studentMapper.getGrade(id);
    }

    @Override
    public Integer getStudentClassroom(Integer id)
    {
        return studentMapper.getClassRoom(id);
    }

    @Override
    public String getStudentEmail(Integer id)
    {
        return studentMapper.getEmail(id);
    }

    @Override
    public Boolean isCommittee(Integer id)
    {
        return studentMapper.getIsCommittee(id) == 1;
    }

    @Override
    public String getStudentPassword(Integer id)
    {
        return studentMapper.getPassword(id);
    }

    @Override
    public Path getFilePath(String uuid)
    {
        return Paths.get(taskMapper.getPath(uuid));
    }

    @Override
    public String getFileName(String uuid)
    {
        return taskMapper.getName(uuid);
    }

    @Override
    public Integer getTaskLuncherID(String uuid)
    {
        return taskMapper.getId(uuid);
    }

    @Override
    public Void AddUndo(String uuid, Integer id)
    {
        String newUndo = studentMapper.getUndo(id)+uuid+",";
        studentMapper.updateUndo(id, newUndo);
        return null;
    }

    @Override
    public Void AddUndoToAll(String uuid, Integer committee)
    {
        Student student = studentMapper.getStudent(committee);
        List<Integer> ids = studentMapper.getSameClassroom(student);
        for (Integer id : ids) {
            String newUndo = studentMapper.getUndo(id)+uuid+",";
            studentMapper.updateUndo(id, newUndo);
        }
        return null;
    }

    @Override
    public Void AddDone(String uuid, Integer id)
    {
        String newDone = studentMapper.getDone(id)+uuid+",";
        studentMapper.updateDone(id, newDone);
        return null;
    }

    @Override
    public Void RemoveUndo(String uuid, Integer id)
    {
        String newUndo = studentMapper.getUndo(id).replace(uuid+",", "");
        studentMapper.updateUndo(id, newUndo);
        return null;
    }

    @Override
    public Void RemoveDone(String uuid, Integer id)
    {
        String newDone = studentMapper.getDone(id).replace(uuid+",", "");
        studentMapper.updateDone(id, newDone);
        return null;
    }
}
