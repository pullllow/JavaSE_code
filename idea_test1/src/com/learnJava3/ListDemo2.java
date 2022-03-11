package com.learnJava3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        /*
        * ArrayList   底层结构数组 查询快 增删慢
        * LinkedList  底层结构链表 查询慢 增删快
        *
        *
        * */
        list.add("1");
        list.add("12");
        list.add("123");

        for(String m : list){
            System.out.println(m);

        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

        LinkedList<String> linked = new LinkedList<String>();

        linked.add("3");
        linked.add("32");
        linked.add("321");

        for(String m : linked){
            System.out.println(m);

        }
        for(int i=0;i<linked.size();i++){
            System.out.println(linked.get(i));
        }
         it = linked.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }
}
