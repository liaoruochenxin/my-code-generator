package com.xj;

import com.xj.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
//        args = new String[] {"list"};
        args = new String[] {"generate", "-l", "-a", "-o"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
