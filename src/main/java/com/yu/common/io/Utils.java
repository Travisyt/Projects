package com.yu.common.io;

import java.io.File;

public class Utils {

    public static boolean isDir(String fileName){
        boolean check;
        File file = new File(fileName);
        return file.isDirectory();
    }

}
