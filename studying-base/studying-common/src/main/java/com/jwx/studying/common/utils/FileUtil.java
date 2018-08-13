package com.jwx.studying.common.utils;

import com.sxc.diamond.common.Constants;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Description: 文件读取工具类
 *
 * <p>
 * PackageName:com.jwx.studying.common.utils
 * FileName: FileUtil.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/24
 */
public class FileUtil {
    public static boolean isFile(String path) {
        File file = new File(path);
        return file.isFile();
    }


    public static boolean isDirectory(String path) {
        File dir = new File(path);
        return dir.isDirectory();
    }


    public static String getFileName(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            throw new RuntimeException("此路径表达的不是文件");
        }
        return file.getName();
    }


    public static String getParentDir(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            throw new RuntimeException("此路径表达的不是文件");
        }
        File parent = file.getParentFile();
        if (parent.isDirectory()) {
            return parent.getName();
        }
        else {
            throw new RuntimeException("父目录不是目录");
        }
    }


    public static String getGrandpaDir(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            throw new RuntimeException("此路径表达的不是文件");
        }
        File parent = file.getParentFile();
        if (parent.isDirectory()) {
            File grandpa = parent.getParentFile();
            if (grandpa.isDirectory()) {
                return grandpa.getName();
            }
            else {
                throw new RuntimeException("祖目录不是目录");
            }
        }
        else {
            throw new RuntimeException("父目录不是目录");
        }
    }


    public static String getFileContent(String path) throws IOException {
        File tFile = new File(path);
        if (!tFile.isFile()) {
            throw new RuntimeException("不是文件");
        }
        RandomAccessFile file = new RandomAccessFile(tFile, "r");
        long fileSize = file.length();
        byte[] bytes = new byte[(int) fileSize];
        long readLength = 0L;
        while (readLength < fileSize) {
            int onceLength = file.read(bytes, (int) readLength, (int) (fileSize - readLength));
            if (onceLength > 0) {
                readLength += onceLength;
            }
            else {
                break;
            }
        }
        try {
            file.close();
        }
        catch (Exception e) {

        }
        return new String(bytes, Constants.ENCODE);
    }
}