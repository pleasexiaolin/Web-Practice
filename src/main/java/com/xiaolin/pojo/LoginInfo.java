package com.xiaolin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzh
 * @description: 登录返回info
 * @date 2025/11/11 8:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Integer id; //员工ID
    private String username; //用户名
    private String name; //姓名
    private String token; //令牌
}
