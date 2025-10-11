### 代码生成器   

- 本项目用于制作一个代码模板生成器，主要用于本人一些定制化需求，同时根据通用场景做出一些扩展。本文档后续主要用于记录过程

#### 25-8-2

- 项目初始化
- github仓库初始化
#### 25-8-3
- 静态文件复制
#### 25-8-4
- 动态文件生成

#### maven输出乱码解决

````java
setupEnvironment(processBuilder.environment());

public static void setupEnvironment(Map<String, String> env) {
        env.put("JAVA_TOOL_OPTIONS", "-Dfile.encoding=UTF-8");
        env.put("MAVEN_OPTS", "-Dfile.encoding=UTF-8");
        env.put("LANG", "en_US.UTF-8");
        env.put("LC_ALL", "en_US.UTF-8");
    }
````

