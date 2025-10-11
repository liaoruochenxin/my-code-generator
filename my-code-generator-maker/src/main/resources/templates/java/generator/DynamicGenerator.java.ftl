package ${basePackage}.generator;

import ${basePackage}.model.DataModel;
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
        DataModel mainTemplateConfig = (DataModel) model;

        mainTemplateConfig.setAuthor(mainTemplateConfig.getAuthor());
        mainTemplateConfig.setLoop(mainTemplateConfig.isLoop());
        mainTemplateConfig.setOutputText(mainTemplateConfig.getOutputText());
        // 在创建 FileWriter 之前添加：
        File outputFile = new File(outputPath);
        File parentDir = outputFile.getParentFile();

        // 如果父目录不存在，则创建
        if (parentDir != null && !parentDir.exists()) {
        boolean dirsCreated = parentDir.mkdirs(); // 创建所有不存在的父目录
        if (!dirsCreated) {
        throw new IOException("无法创建目录: " + parentDir.getAbsolutePath());
        }
        }

        // 然后再创建文件写入器
        try (FileWriter writer = new FileWriter(outputPath)) {
        template.process(mainTemplateConfig, writer);
        }

    }
}