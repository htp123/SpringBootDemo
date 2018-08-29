package com.example.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/29.
 */
public class Convert {

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }
}
