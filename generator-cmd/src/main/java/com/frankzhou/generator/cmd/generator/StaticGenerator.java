package com.frankzhou.generator.cmd.generator;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Arrays;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 静态代码生成
 * @date 2024-01-21
 */
public class StaticGenerator {

    public static void main(String[] args) {
        String homePath = System.getProperty("user.dir");
        String inputPath = new File(homePath, "generator-cmd/src/main/java/com/frankzhou/generator/cmd/code").getAbsolutePath();
        String outputPath = homePath + File.separator + "code";
        System.out.println("home:" + homePath + " input:" + inputPath + " output" + outputPath);
        // FileUtil.copy(inputPath,outputPath,false);

        // 列出文件目录
        String listPath = homePath + File.separator + "generator-cmd";
        listFile(new File(listPath));
    }

    private static void listFile(File inputFile) {
        if (inputFile.isDirectory()) {
            // 如果是目录
            String fileName = inputFile.getName();
            System.out.println(fileName);

            File[] subFiles = inputFile.listFiles();
            if (ArrayUtil.isEmpty(subFiles)) {
                return;
            }

            for (File subFile : subFiles) {
                listFile(subFile);
            }
        } else {
            // 如果不是目录
            String fileName = inputFile.getName();
            System.out.println(fileName);
            return;
        }
    }
}
