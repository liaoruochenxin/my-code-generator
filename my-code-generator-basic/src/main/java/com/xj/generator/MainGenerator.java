package com.xj.generator;

import com.xj.model.MainTemplateConfig;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        String inputRootPath = "D:\\study\\code\\my-code-generator\\first-phase-demo\\template";
        String outputRootPath = "generated";

        String inputPath;
        String outputPath;
        // 生成动态文件
        inputPath = new File(inputRootPath, "src/main/resources/template/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/main/resources/template/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);

        // 生成静态文件
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("蒋炜");
        mainTemplateConfig.setOutputText("8-5");
        mainTemplateConfig.setLoop(true);
        doGenerator(mainTemplateConfig);
    }
}
