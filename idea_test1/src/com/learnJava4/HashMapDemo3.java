package com.learnJava4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo3 {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> array = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> hm1 = new HashMap<String, String>();
        hm1.put("a", "1");
        hm1.put("b", "2");

        array.add(hm1);

        HashMap<String, String> hm2 = new HashMap<String, String>();
        hm2.put("c", "3");
        hm2.put("d", "4");

        array.add(hm2);
        HashMap<String, String> hm3 = new HashMap<String, String>();
        hm3.put("阿", "5");
        hm3.put("哦", "6");

        array.add(hm3);

        for (HashMap<String, String> hm : array) {
            Set<String> keySet = hm.keySet();
            for (String key : keySet) {
                System.out.println(key + "," + hm.get(key));

            }
        }
    }
}
