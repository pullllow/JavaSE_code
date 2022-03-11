package com.learnJava4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        //创建集合对象
        Map<String, String> map = new HashMap<String, String>();

        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        /*Set<String> keySet = map.keySet();

        for (String key : keySet) {
            String value = map.get(key);
            System.out.println(key + ',' + value);
        }*/

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> m : entrySet) {
            System.out.println(m.getKey() + ',' + m.getValue());
        }

    }
}
