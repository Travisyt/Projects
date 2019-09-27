package com.yu.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassUtils{

    /**
     * 通过反射获取变量列表。
     * @param clazz 传入Class对象。
     * @return infoList 返回对象的成员变量列表。
     */
    public static List<String> getInfoList(Class clazz) {

        List<String> infoList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            infoList.add(field.getName());
        }
        return infoList;

    }

    // 调用无参构造
    public static <T> T newInstance(Class<T> tClass){
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
