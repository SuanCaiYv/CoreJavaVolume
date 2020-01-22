package com.example.test.tools;

import com.example.test.dao.TaskMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午4:37
 */
@Component
public class FileUtil
{
    @Autowired
    private TaskMapper taskMapper;
    public FileUtil()
    {
        deleteAtFixedRate();
    }
    public static String getUuid()
    {
        return UUID.randomUUID().toString();
    }
    public static void deleteDir(Path path) throws IOException
    {
        FileUtils.deleteDirectory(path.toFile());
    }
    public void deleteAtFixedRate()
    {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        DeleteFile deleteFile = new DeleteFile(taskMapper);
        service.scheduleAtFixedRate(deleteFile, 0, 1, TimeUnit.DAYS);
    }
    public static void saveFile(MultipartFile multipartFile, Path path) throws IOException
    {
        multipartFile.transferTo(path);
    }
    public static void downloadFile(HttpServletResponse response, Path path)
    {
        ;
    }
}
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
                FileUtil.deleteDir(Paths.get(p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
