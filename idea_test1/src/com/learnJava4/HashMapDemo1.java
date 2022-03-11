package com.learnJava4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1 {
    public static void main(String[] args) {
        HashMap<String, Student> hm = new HashMap<String, Student>();

        Student s1 = new Student("a", 12);
        Student s2 = new Student("b", 13);
        Student s3 = new Student("c", 14);

        hm.put("001", s1);
        hm.put("002", s2);
        hm.put("003", s3);

        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            Student value = hm.get(key);
            System.out.println(key + ',' + value.getName() + ',' + value.getAge());

        }
        System.out.println("-------------");
        Set<Map.Entry<String, Student>> entrySet = hm.entrySet();
        for(Map.Entry<String,Student> entry: entrySet){
            System.out.println(entry.getKey() + ',' + entry.getValue().getName() + ',' + entry.getValue().getAge());
        }



    }
}
