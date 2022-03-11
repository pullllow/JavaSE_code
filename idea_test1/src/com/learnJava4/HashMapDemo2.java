package com.learnJava4;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo2 {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<Student, String>();


        Student s1 = new Student("a", 12);
        Student s2 = new Student("b", 13);
        Student s3 = new Student("c", 14);
        Student s4 = new Student("c", 14);

        hm.put(s1, "beijing");
        hm.put(s2, "nanjing");
        hm.put(s3, "dongjing");
        hm.put(s4, "shanghai");

        Set<Student> keySet = hm.keySet();
        for (Student s : keySet) {
            System.out.println(s.getName() + "," + s.getAge() + "," + hm.get(s));
        }


    }
}
