package com.example.test.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午5:34
 */
@Service
public interface MessageService
{
    // 返回的都是UUID, 不是文件名
    String[] getUndos(Integer id);
    String[] getDones(Integer id);
    // 哈希映射为:UUID-文件名
    HashMap<String, String> getUndoUUIDAndFileNameMap(Integer id);
    HashMap<String, String> getDoneUUIDAndFileNameMap(Integer id);
    String getStudentName(Integer id);
    String getStudentDepartment(Integer id);
    Integer getStudentGrade(Integer id);
    Integer getStudentClassroom(Integer id);
    String getStudentEmail(Integer id);
    Boolean isCommittee(Integer id);
    String getStudentPassword(Integer id);
    Path getFilePath(String uuid);
    String getFileName(String uuid);
    Integer getTaskLuncherID(String uuid);
    Void AddUndo(String uuid, Integer id);
    Void AddUndoToAll(String uuid, Integer committee);
    Void AddDone(String uuid, Integer id);
    Void RemoveUndo(String uuid, Integer id);
    Void RemoveDone(String uuid, Integer id);
}
