package com.xiaolin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lzh
 * @description: TODO
 * @date 2025/11/13 23:41
 */
@Data
@NoArgsConstructor
public class ClazzOption {
    //班级
    private List<Object> clazzList;

    // 数据
    private List<Object> dataList;

    public ClazzOption(List<Object> clazzList, List<Object> dataList) {
        this.clazzList = clazzList;
        this.dataList = dataList;
    }
}
