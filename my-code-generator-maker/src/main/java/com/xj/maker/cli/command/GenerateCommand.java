package com.xj.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.xj.maker.generator.file.FileGenerator;
import com.xj.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine.*;

import java.util.concurrent.Callable;

/**
 * 生成文件命令
 * 接收参数并生成代码
 */
@Command(name = "generate", description = "生成代码",  mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环",
    interactive = true, echo = true)
    private Boolean loop;

    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "小蒋";

    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum = ";
    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("配置信息：" + dataModel);
        FileGenerator.doGenerator(dataModel);
        return 0;
    }
}
