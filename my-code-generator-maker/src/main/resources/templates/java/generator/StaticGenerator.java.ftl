package "${basePackage}".generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author ${author}
 * 静态文件复制类
 */
public class StaticGenerator {
    public static void copyFilesByHutool(String inputPtah, String outputPtah) {
        FileUtil.copy(inputPtah, outputPtah, false);
    }
}