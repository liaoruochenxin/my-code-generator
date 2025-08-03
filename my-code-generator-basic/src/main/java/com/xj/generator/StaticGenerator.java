package com.xj.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author jiangwei
 * 静态文件复制类
 */
public class StaticGenerator {
    public static void main(String[] args) {
        // 获取项目根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "first-phase-demo/template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);
    }

    public static void copyFilesByHutool(String inputPtah, String outputPtah) {
        FileUtil.copy(inputPtah, outputPtah, false);
    }
}
