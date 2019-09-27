package com.yu.common.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    /**
     *
     * @param fileName 写入文件名
     * @param info 写入字符串
     */
    public static void addToFile(String fileName, String info){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(info);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入列表
     * @param fileName 写入文件名。
     * @param infos 写入信息列表。
     */
    public static void addToFile(String fileName, List<String> infos){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String info : infos) {
                bufferedWriter.write(info);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void initFile(String fileName) throws Exception {
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(file.isDirectory()) {
            throw new Exception("目标文件是目录");
        }
    }

}
