package com.xj.generator;

import com.xj.model.MainTemplateConfig;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "first-phase-demo/template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java";

        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("蒋炜");
        mainTemplateConfig.setOutputText("8-5");
        mainTemplateConfig.setLoop(true);
        doGenerator(mainTemplateConfig);
    }
}
