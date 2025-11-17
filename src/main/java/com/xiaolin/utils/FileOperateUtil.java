package com.xiaolin.utils;

import cn.hutool.core.io.FileUtil;
import com.aliyun.oss.OSS;
import com.xiaolin.aop.LogCall;
import com.xiaolin.client.AliyunOssClient;
import com.xiaolin.common.Result;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author lzh
 * @description: 文件util
 * @date 2025/11/11 19:23
 */
@Slf4j
public class FileOperateUtil {

    // 上传到本地的地址
    private static final String UPLOAD_DIR = "D:/file/";

    // 填写Bucket名称，例如examplebucket。
    private static final String bucketName = "aliyun-xiaolin";

    private static final String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";

    /**
     * 上传
     *
     * @param file 接收的文件
     * @param flag true -> OSS     false -> 本地
     * @return 返回路径
     * @throws IOException
     */
    @LogCall
    public static Result upload(MultipartFile file, Boolean flag) throws IOException {

        if (!file.isEmpty()) {
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();

            // 填写Object完整路径，例如2025/11/a.png。Object完整路径中不能包含Bucket名称。
            //获取当前系统日期的字符串,格式为 yyyy/MM
            String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            //生成一个新的不重复的文件名
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = dir + "/" + newFileName;

            if (flag) { // 上传OSS

                // 获取OssClient
                OSS ossClient = AliyunOssClient.getOssClient();

                if (ossClient == null) {
                    return Result.error("上传超时，请耐心等待。");
                }

                try {
                    ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(file.getBytes()));
                } catch (Exception e) {
                    log.error("创建OSS失败！{}", e.getMessage());
                    return Result.error("上传超时，请耐心等待。");
                } finally {
                    ossClient.shutdown();
                }

                return Result.success(endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName);
            } else {  // 上传到本地

                // 拼接完整的文件路径
                File targetFile = new File(UPLOAD_DIR + newFileName);

                // 如果目标目录不存在，则创建它
                if (!targetFile.getParentFile().exists()) {
                    boolean dirCreated = targetFile.getParentFile().mkdirs();
                    if (!dirCreated) {
                        throw new IOException("Failed to create directory: " + targetFile.getParentFile().getAbsolutePath());
                    }
                }
                // 保存文件
                file.transferTo(targetFile);
                return Result.success(UPLOAD_DIR);
            }
        }

        return Result.error("文件不存在！");
    }

    @LogCall
    public static Result download(String path, String name, HttpServletResponse response) {

        try (ServletOutputStream outputStream = response.getOutputStream();
             OutputStream toClient = new BufferedOutputStream(outputStream)) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment; fileName=" + name);
            FileUtil.writeToStream(new File(path), toClient);
        } catch (IOException e) {
            return Result.error("资源被删除，无法下载。");
        }

        return Result.success();
    }
}
