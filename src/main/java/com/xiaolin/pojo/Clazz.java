package com.xiaolin.pojo;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lzh
 * @description: 班级表
 * @date 2025/11/12 8:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id; //ID
    private String name; //班级名称
    private String room; //班级教室
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    private Date beginDate; //开课时间
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    private Date endDate; //结课时间
    private Integer masterId; //班主任
    private Integer subject; //学科
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private Date createTime; //创建时间
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private Date updateTime; //修改时间

    private String masterName; //班主任姓名
    private String status; //班级状态 - 未开班 , 在读 , 已结课
}
