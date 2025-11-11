package com.xiaolin.pojo;

import com.xiaolin.common.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author lzh
 * @description: 分页查询参数
 * @date 2025/11/9 18:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmpQueryParam extends PageQuery {
    private String name; //姓名
    private Integer gender; //性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //入职开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //入职结束时间
}
