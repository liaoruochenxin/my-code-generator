package "${basePackage}".generator;

import "${basePackage}".model.MainTemplateConfig;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;
        <#list fileConfig.files as fileInfo>
            inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
            outputPath = new File(outputRootPath, "${fileInfo.outputPath}).getAbsolutePath();
            <#if fileInfo.generateType == "dynamic">
                // 生成动态文件
                DynamicGenerator.doGenerate(inputPath, outputPath, model);
            <#else>
                // 生成静态文件
                StaticGenerator.copyFilesByHutool(inputPath, outputPath);
            </#if>
        </#list>
    }
}