package com.xj.maker.generator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JarGenerator {

    public static void doGenerator(String projectPath) throws IOException, InterruptedException {
        // ����Process��ִ��Maven�������
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true -Dfile.encoding=UTF-8 -X -e";
        String otherMavenCommand = "mvn clean package -DskipTests=true -Dfile.encoding=UTF-8";

        String mavenCommand = winMavenCommand;

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectPath));
        setupEnvironment(processBuilder.environment());
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
            System.out.println(new String(line.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        }

        int exitCode = process.waitFor();
        System.out.println("ִ命令执行结束，退出码:" + exitCode);
    }

    public static void setupEnvironment(Map<String, String> env) {
        env.put("JAVA_TOOL_OPTIONS", "-Dfile.encoding=UTF-8");
        env.put("MAVEN_OPTS", "-Dfile.encoding=UTF-8");
        env.put("LANG", "en_US.UTF-8");
        env.put("LC_ALL", "en_US.UTF-8");
    }


}
