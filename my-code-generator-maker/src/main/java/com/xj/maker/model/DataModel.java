package com.xj.maker.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class DataModel {
    /**
     * 是否生成循环
     */
    private Boolean loop;

    /**
     * 作者注释
     */
    private String author;

    /**
     * 输出信息
     */
    private String outputText = "Default value";
}
