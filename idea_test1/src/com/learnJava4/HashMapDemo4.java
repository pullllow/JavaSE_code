package com.learnJava4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo4 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

        ArrayList<String> array1 = new ArrayList<String>();
        array1.add("诸葛亮");
        array1.add("赵云");

        hm.put("三国演义", array1);

        ArrayList<String> array2 = new ArrayList<String>();
        array2.add("孙悟空");
        array2.add("猪八戒");

        hm.put("西游记", array2);

        ArrayList<String> array3 = new ArrayList<String>();
        array3.add("武松");
        array3.add("林冲");

        hm.put("水浒传", array3);

        Set<Map.Entry<String, ArrayList<String>>> entrySet = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> m : entrySet) {
            System.out.println(m.getKey());
            for (String s : m.getValue()) {
                System.out.println('\t' + s);
            }
        }


    }
}
