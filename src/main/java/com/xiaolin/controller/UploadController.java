package com.xiaolin.controller;

import com.xiaolin.common.Result;
import com.xiaolin.utils.FileOperateUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author lzh
 * @description: 上传Controller
 * @date 2025/11/10 9:10
 */
@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartFile file) throws IOException {
        return FileOperateUtil.upload(file, false);
    }

    @GetMapping("/download")
    public Result download(String path, String fileName, HttpServletResponse response) {
        return FileOperateUtil.download(path, fileName, response);
    }
}
