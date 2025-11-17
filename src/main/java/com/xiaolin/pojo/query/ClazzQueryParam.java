package com.xiaolin.pojo.query;

import com.xiaolin.common.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author lzh
 * @description: 班级查询请求
 * @date 2025/11/12 9:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ClazzQueryParam extends PageQuery {
    private String name;// 班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;// 开课时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;// 结束时间
    private Integer masterId; //班主任
    private Integer subject; //学科
}
