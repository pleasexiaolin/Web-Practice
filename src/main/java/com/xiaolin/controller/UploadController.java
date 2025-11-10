package com.xiaolin.controller;

import com.xiaolin.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author lzh
 * @description: 上传Controller
 * @date 2025/11/10 9:10
 */
@Slf4j
@RestController
public class UploadController {

    @GetMapping("/upload")
    public Result upload(String name, String age, MultipartFile file) throws IOException {

        log.info("上传文件为：{}，{}，{}", name, age, file);

        if (!file.isEmpty()) {
            file.transferTo(new File("D:\\file\\images" + file.getOriginalFilename()));
        }

        return Result.success();
    }
}
