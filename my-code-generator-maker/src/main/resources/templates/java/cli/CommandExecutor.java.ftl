package ${basePackage}.maker.cli;

import ${basePackage}.maker.cli.command.ConfigCommand;
import ${basePackage}.maker.cli.command.GenerateCommand;
import ${basePackage}.maker.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * 命令执行器
 */
@Command(name = "jiangwei", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 未输入命令时提示
        System.out.println("请输入具体命令，或输入 --help 查看命令提示");
    }

    // 执行命令
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
