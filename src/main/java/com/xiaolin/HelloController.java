package com.xiaolin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzh
 * @description: 测试Controller
 * @date 2025/11/7 18:45
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/web")
    public String helloWeb(String name) {
        System.out.println(name + " hello come Web!");
        return "welcome " + name + " come Web！";
    }

}
