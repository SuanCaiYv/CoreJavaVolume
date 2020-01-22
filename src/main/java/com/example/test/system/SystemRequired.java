package com.example.test.system;

import com.example.test.dao.TaskMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午5:37
 */
@Component
public class SystemRequired
{
    @Autowired
    private TaskMapper taskMapper;

    /**
     * 在无参构造函数中, 启动所有系统服务
     */
    public SystemRequired()
    {
        deleteAtFixedRate();
    }

    /**
     * 每隔一天执行一次, 检查是否有任务需要删除
     */
    public void deleteAtFixedRate()
    {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        DeleteFile deleteFile = new DeleteFile(taskMapper);
        service.scheduleAtFixedRate(deleteFile, 0, 1, TimeUnit.DAYS);
    }
}

/**
 * 此类进行删除7天文件功能, 需要提供一个TaskMapper进行构造
 * 将作为一个线程在定时任务里运行
 */
class DeleteFile implements Runnable
{
    private TaskMapper taskMapper;
    public DeleteFile(TaskMapper taskMapper)
    {
        this.taskMapper = taskMapper;
    }
    @Override
    public void run()
    {
        List<String> paths = taskMapper.getTaskPathNeededDeleted(System.currentTimeMillis()-7*24*60*60*1000);
        paths.forEach(p->{
            try {
                FileUtils.deleteDirectory(new File(p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
