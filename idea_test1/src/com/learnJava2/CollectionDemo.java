package com.learnJava2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<Student> c = new ArrayList<Student>() ;
        Student s1 = new Student("n1", 12);
        Student s2 = new Student("n2", 13);
        Student s3 = new Student("n3", 14);

        c.add(s1);
        c.add(s2);
        c.add(s3);

        Iterator<Student> it = c.iterator();
        while(it.hasNext()){
            Student s = it.next();
            System.out.println("name:"+s.getName()+",age:"+s.getAge());
        }


     }
}
