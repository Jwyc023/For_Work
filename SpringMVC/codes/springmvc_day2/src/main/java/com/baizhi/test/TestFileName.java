package com.baizhi.test;

import org.apache.commons.io.FilenameUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TestFileName {
    public static void main(String[] args) {
        String fileName = "自我介绍-sssss.aa.txt";

        //1.分割符
        String[] split = fileName.split("\\.");
        System.out.println(split[split.length-1]);

        //2.字符串subString
        int i = fileName.lastIndexOf(".");
        String substring = fileName.substring(i);
        System.out.println(substring);

        //3.工具类型 commons-fileupload 工具类
        String extension = FilenameUtils.getExtension(fileName);
        System.out.println(extension);

        System.out.println(new Date());
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println(format);
        System.out.println(LocalDate.now());
    }
}
