package com.yu.common.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String NULL = "null";

    /**
     * list转为小写
     * @param list
     */
    public static void listToLowerCase(List<String> list) {
        for(int i = 0;i < list.size();++i) {
            list.set(i, list.get(i).toLowerCase());
        }
    }

    public static String findValueByKey(String string, String key) {
        Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find())
            return matcher.group(1);
        else return "null";
    }


}
