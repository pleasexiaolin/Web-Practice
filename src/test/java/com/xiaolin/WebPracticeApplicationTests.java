package com.xiaolin;

import com.xiaolin.mapper.EmpMapper;
import com.xiaolin.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebPracticeApplicationTests {


    @Autowired
    private EmpMapper empMapper;

    @Test
    void contextLoads() {
        //List<Emp> empList = empMapper.list();
        //empList.forEach(System.out::println);
    }

}
