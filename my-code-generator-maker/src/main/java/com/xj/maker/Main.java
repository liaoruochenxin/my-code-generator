package com.xj.maker;

import com.xj.maker.cli.CommandExecutor;
import com.xj.maker.generator.MainGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
//        args = new String[] {"list"};
//        args = new String[] {"generate", "-l", "-a", "-o"};
//        CommandExecutor commandExecutor = new CommandExecutor();
//        commandExecutor.doExecute(args);

        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
