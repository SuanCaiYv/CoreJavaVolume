package com.example.test.service.impl;

import com.example.test.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午5:35
 */
@Service
public class FileServiceImpl implements FileService
{
    /**
     * 如果文件存在, 删除, 保存
     * @param multipartFile NA
     * @param path NA
     */
    @Override
    public void saveFile(MultipartFile multipartFile, Path path)
    {
        ;
    }

    /**
     * 每次读取1M, 避免爆内存
     * @param response NA
     * @param path NA
     */
    @Override
    public void downloadFile(HttpServletResponse response, Path path)
    {
        ;
    }
}
