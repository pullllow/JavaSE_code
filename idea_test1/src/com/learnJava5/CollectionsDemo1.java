package com.learnJava5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsDemo1 {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();

        Student s1 = new Student("a", 12);
        Student s2 = new Student("b", 13);
        Student s3 = new Student("c", 14);

        array.add(s1);
        array.add(s2);
        array.add(s3);


        System.out.println(array);
        for (Student s : array) {
            System.out.println(s.getName() + "," + s.getAge());
        }


        Collections.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num1 = o2.getAge() - o1.getAge();
                int num2 = num1 == 0 ? o2.getName().compareTo(o1.getName()) : num1;
                return num2;
            }
        });

        for (Student s : array) {
            System.out.println(s.getName() + "," + s.getAge());
        }

    }
}
