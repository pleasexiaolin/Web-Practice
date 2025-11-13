package com.xiaolin.pojo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 部门表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Dept {
    /**
     * ID, 主键
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}