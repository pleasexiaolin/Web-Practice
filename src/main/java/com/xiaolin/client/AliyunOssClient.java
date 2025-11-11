package com.xiaolin.client;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.comm.SignVersion;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lzh
 * @description: 阿里云OSS
 * @date 2025/11/11 21:38
 */
@Slf4j
public class AliyunOssClient {

    public static OSS getOssClient() {
        // 从环境变量获取访问凭证
        OSS oss = null;
        try {
            String accessKeyId = System.getenv("OSS_ACCESS_KEY_ID");
            String accessKeySecret = System.getenv("OSS_ACCESS_KEY_SECRET");

            // 设置OSS地域和Endpoint
            String region = "cn-hangzhou";
            String endpoint = "oss-cn-hangzhou.aliyuncs.com";

            // 创建凭证提供者
            DefaultCredentialProvider provider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);

            // 配置客户端参数
            ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
            // 显式声明使用V4签名算法
            clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);

            // 初始化OSS客户端
            oss = OSSClientBuilder.create()
                    .credentialsProvider(provider)
                    .clientConfiguration(clientBuilderConfiguration)
                    .region(region)
                    .endpoint(endpoint)
                    .build();
        } catch (Exception e) {
            log.error("创建OSS失败！{}", e.getMessage());
        }

        return oss;
    }



}
