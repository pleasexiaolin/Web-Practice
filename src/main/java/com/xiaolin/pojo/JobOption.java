package com.xiaolin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 报表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    // 职位
    private List<String> jobList;
    // 数据
    private List<String> dataList;
}
