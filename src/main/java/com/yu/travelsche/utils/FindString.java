package com.yu.travelsche.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindString {

    public static String findByKey(String string, String key){
        Pattern pattern = Pattern.compile("\""+key+"\"\\s*:\\s*\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find())
            return matcher.group(1);
        else return "null";
    }

    /*
    public static List<String> findKeyList(String example){
        List<String> keys = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"(.*)\"\\s*:\\s*\".*\"");
        Matcher matcher = pattern.matcher(example);
        if(matcher.find()){
            int count = matcher.groupCount();

        }

        return keys;
    }
*/

//    demo
//    public static void main(String[] args) {
//        String temp = "\"tranid\":\"K526\"\t\"from\":\"FZS\"\t\"to\":\"NJH\"\t\"depart\":\"SNH\"\t\"arri\":\"NJH\"\t\"deptime\":\"04:14\"\t\"arritime\":\"08:10\"\t\"timecost\":\"03:56\"\t\"date\":\"20190909\"\t\"noseat\":\"无\"\t\"secondseat\":\"有\"\t\"firstseat\":\"无\"\t\"bussiseat\":\"无\"\t";
////        System.out.println(FindString.findByKey(temp, "asd"));
//        System.out.println(temp);
//
//        Pattern pattern = Pattern.compile("\"(.*)\"\\s*:\\s*\".*\"");
//        Matcher matcher = pattern.matcher(temp);
//        matcher.find();
//        System.out.println(matcher.group(1));
////        System.out.println(matcher.group(2));
////        System.out.println(matcher.group(3));
//
//
//    }

}
