package com.xj.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @author jiangwei
 * 静态文件复制类
 */
public class StaticFileGenerator {

    public static void copyFilesByHutool(String inputPtah, String outputPtah) {
        FileUtil.copy(inputPtah, outputPtah, false);
    }
}
