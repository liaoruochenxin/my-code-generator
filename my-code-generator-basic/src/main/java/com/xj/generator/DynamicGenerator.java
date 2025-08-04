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
}
