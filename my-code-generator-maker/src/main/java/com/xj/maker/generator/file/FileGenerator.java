package com.xj.maker.generator.file;

import com.xj.maker.model.DataModel;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.IOException;

public class FileGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "first-phase-demo/template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java";

        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("蒋炜");
        dataModel.setOutputText("8-5");
        dataModel.setLoop(true);
        doGenerator(dataModel);
    }
}
