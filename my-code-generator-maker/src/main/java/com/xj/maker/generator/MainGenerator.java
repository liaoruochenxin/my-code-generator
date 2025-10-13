package com.xj.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.xj.maker.generator.file.DynamicFileGenerator;
import com.xj.maker.generator.main.GeneratorTemplate;
import com.xj.maker.meta.Meta;
import com.xj.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator extends GeneratorTemplate {
    @Override
    protected void buildDist(String outputPath, String jarPath, String shellOutputFilePath, String sourceCopyDestPath) {
        System.out.println("不要给我输出 dist 啦");
    }

    //    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        Meta meta = MetaManager.getMetaObject();
//        System.out.println(meta);
//
//        // 输出的根路径
//        String projectPath = System.getProperty("user.dir");
//        String outputPath = projectPath + File.separator + "generator";
//        if (!FileUtil.exist(outputPath)) {
//            FileUtil.mkdir(outputPath);
//        }
//
//        // 读取resource目录
//        ClassPathResource classPathResource = new ClassPathResource("");
//        String inputResourcePath = classPathResource.getAbsolutePath();
//
//        // 包基础路径
//        String outputBasePackage = meta.getBasePackage();
//        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
//        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/" + outputBasePackagePath;
//
//        String outputFilePath;
//        String inputFilePath;
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/mode/DataModel.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/command/GenerateCommand.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ListCommand.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/CommandExecutor.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/DynamicGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/DynamicGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/MainGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/MainGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/StaticGenerator.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/generator/StaticGenerator.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
//        outputFilePath = outputBaseJavaPackagePath + "/Main.java";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        inputFilePath = inputResourcePath + File.separator + "templates/pom.xml.ftl";
//        outputFilePath = outputPath + File.separator + "pom.xml";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        // 模板文件复制
//        String sourceRootPath = meta.getFileConfig().getSourceRootPath();
//        String sourceCopyDestPath = outputPath + File.separator + ".source";
//        FileUtil.copy(sourceRootPath, sourceCopyDestPath, false);
//
//        // README.md
//        inputFilePath = inputResourcePath + File.separator + "templates/README.md.ftl";
//        outputFilePath = outputPath + File.separator + "README.md";
//        DynamicFileGenerator.doGenerate(inputFilePath, outputFilePath, meta);
//
//        // 构建Jar包
//        JarGenerator.doGenerator(outputPath);
//
//        // 封装脚本
//        String shellOutputFilePath = outputPath + File.separator + "generator";
//        String jarName = String.format("%s-%s-jar-with-dependencies.jar", meta.getName(), meta.getVersion());
//        String jarPath = "target/" + jarName;
//        ScriptGenerator.doGenerator(shellOutputFilePath, jarPath);
//
//        // 生成精简版程序(产物包)
//        String distOutputPath = outputPath + "-dist";
//        // 拷贝jar包
//        String targetAbsolutePath = distOutputPath + File.separator + "target";
//        FileUtil.mkdir(targetAbsolutePath);
//        String jarAbsolutePath = outputPath + File.separator + jarPath;
//        FileUtil.copy(jarAbsolutePath, targetAbsolutePath, true);
//        // 拷贝脚本文件
//        FileUtil.copy(shellOutputFilePath, distOutputPath, true);
//        FileUtil.copy(shellOutputFilePath + ".bat", distOutputPath, true);
//        // 拷贝源模板文件
//        FileUtil.copy(sourceCopyDestPath, distOutputPath, true);
//    }
}
