package com.example.test.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;

/**
 * @author SuanCaiYv
 * @time 2020/1/22 下午5:34
 */
@Service
public interface FileService
{
    void saveFile(MultipartFile multipartFile, Path path);
    void downloadFile(HttpServletResponse response, Path path);
}
