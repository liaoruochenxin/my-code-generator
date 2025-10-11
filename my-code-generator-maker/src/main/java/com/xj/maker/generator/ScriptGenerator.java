package com.xj.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ScriptGenerator {


    public static void doGenerator(String outputPath, String jarPath) {
        // linux脚本
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#! /bin/bash\n");
        stringBuilder.append(String.format("java -jar %s \"$@\"", jarPath)).append("\n");
        FileUtil.writeBytes(stringBuilder.toString().getBytes(StandardCharsets.UTF_8), outputPath);
        // 设置文件权限
        try {
            Set<PosixFilePermission> filePermissions = PosixFilePermissions.fromString("rwxrwxrwx");
            Files.setPosixFilePermissions(Paths.get(outputPath), filePermissions);
        } catch (Exception e) {

        }
        // windows脚本
        stringBuilder = new StringBuilder();
        stringBuilder.append("@echo off\n");
        stringBuilder.append(String.format("java -jar %s %%*", jarPath)).append("\n");
        FileUtil.writeBytes(stringBuilder.toString().getBytes(StandardCharsets.UTF_8), outputPath + ".bat");
    }


}
