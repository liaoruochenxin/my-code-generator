package ${basePackage}.cli.command;

import cn.hutool.core.bean.BeanUtil;
import ${basePackage}.generator.MainGenerator;
import ${basePackage}.model.DataModel;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 生成文件命令
 * 接收参数并生成代码
 */
@Command(name = "generate", description = "生成代码",  mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    <#list modelConfig.models as modelInfo>
        <#if modelInfo.groupKey??>
            <#list modelInfo.models as modelInfo>
                @Option(names = {"-${modelInfo.abbr}", "--${modelInfo.fieldName}"}, arity = "0..1", <#if modelInfo.description??>description = "${modelInfo.description} </#if>",
                interactive = true, echo = true)
                private ${modelInfo.type} ${modelInfo.fieldName} <#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
            </#list>
            <#else >
                @Option(names = {"-${modelInfo.abbr}", "--${modelInfo.fieldName}"}, arity = "0..1", <#if modelInfo.description??>description = "${modelInfo.description} </#if>",
                interactive = true, echo = true)
                private ${modelInfo.type} ${modelInfo.fieldName} <#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
        </#if>

    </#list>

    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("配置信息：" + dataModel);
        MainGenerator.doGenerator(dataModel);
        return 0;
    }
}
