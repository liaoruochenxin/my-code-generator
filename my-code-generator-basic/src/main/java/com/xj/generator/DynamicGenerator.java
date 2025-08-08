package com.xj.generator;

import com.xj.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 动态文件生成
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        // 创建配置对象，参数为freemarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

        // 指定模板文件路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/template"));

        configuration.setDefaultEncoding("UTF-8");

        // 加载指定模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");

        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();

        mainTemplateConfig.setAuthor("蒋炜");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("sum =");

        FileWriter fileWriter = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig, fileWriter);

        fileWriter.close();
    }

    /**
     * 生成文件
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // 创建配置对象，参数为freemarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

        // 指定模板文件路径
        configuration.setDirectoryForTemplateLoading(new File(inputPath).getParentFile());

        configuration.setDefaultEncoding("UTF-8");

        // 加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = (MainTemplateConfig) model;

        mainTemplateConfig.setAuthor(mainTemplateConfig.getAuthor());
        mainTemplateConfig.setLoop(mainTemplateConfig.getLoop());
        mainTemplateConfig.setOutputText(mainTemplateConfig.getOutputText());

        FileWriter fileWriter = new FileWriter("MainTemplate.java");
        template.process(mainTemplateConfig, fileWriter);

        fileWriter.close();
    }
}
