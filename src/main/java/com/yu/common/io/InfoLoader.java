package com.yu.common.io;

import com.yu.travelsche.utils.FindString;
import com.yu.common.utils.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.yu.common.utils.ClassUtils.getInfoList;

/**
 * 只能读取一个文件一次性读取到内存
 */

public class InfoLoader {

    public static List<Map<String, String>> getInfoMap(String filename, Class clazz){
        List<Map<String, String>> result= new ArrayList<>();
        Map<String, String> map;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        // 获取变量列表 并转为小写
        List<String> infoList = getInfoList(clazz);
        StringUtils.listToLowerCase(infoList);

        String line = null;
        String temp;

        try {
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()){
                // 依次读行， 空行跳过
                line = bufferedReader.readLine();
                if(line.equals(""))
                    continue;

                map = new HashMap<>();
                for(String info: infoList) {
                    temp = FindString.findByKey(line, info);
                    if(temp.equals(""))
                        temp = "null";
                    map.put(info, temp);
                }

                result.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();

            return result;
        }
        return result;
    }

    /*
    public static void main(String[] args) {
        Set set;
        List<Map<String, String>> result = InfoLoader.getInfoMap("C:\\Users\\YT\\Desktop\\structure\\temp\\transinfos\\1568017076_2019-09-10_SNH_NJH", com.yu.travelsche.beans.TranInfo.class);
        for(Map item : result) {
            set = item.keySet();
            for (Object key : set) {
                System.out.print(key + ":  ");
                System.out.print(item.get((String)key) + ", ");
            }
            System.out.println("");
        }
    }
*/
}
