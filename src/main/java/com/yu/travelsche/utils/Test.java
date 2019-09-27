package com.yu.travelsche.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\YT\\Desktop\\structure\\temp\\transinfos");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        File[] list = file.listFiles();
        for(File f : list){
            System.out.println(f.getAbsolutePath());
        }

    }

}
