package com.xiaolin;

import com.xiaolin.mapper.EmpMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class WebPracticeApplicationTests {


    @Autowired
    private EmpMapper empMapper;

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
