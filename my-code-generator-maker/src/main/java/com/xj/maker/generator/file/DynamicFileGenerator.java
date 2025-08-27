package com.xj.maker.generator.file;

import cn.hutool.core.io.FileUtil;
import com.xj.maker.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 动态文件生成
 */
public class DynamicFileGenerator {
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

        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }


        FileWriter fileWriter = new FileWriter(outputPath);
        template.process(model, fileWriter);


        fileWriter.close();
    }
}
