package com.xiaolin;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class WebPracticeApplicationTests {

    @Test
    void contextLoads() {
        String filename = "abc.pdf";
        String ext = StringUtils.substringAfterLast(filename, ".");
        System.out.println(ext);
        //String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + ext;


        String extName = filename.substring(filename.lastIndexOf("."));
        System.out.println(extName);
        String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
        // 拼接完整的文件路径
        //File targetFile = new File(UPLOAD_DIR + uniqueFileName);

        System.out.println(uniqueFileName);

    }



}
