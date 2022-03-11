package com.learnJava6;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
        //集合中的数据保存到文件
        myStore();

        //文件中的数据加载到集合
        myLoqd();
    }

    private static void myLoqd() throws IOException {
        Properties prop = new Properties();

        FileReader fr = new FileReader("idea_test1\\fw.txt");

        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("001", "刘备");
        prop.setProperty("002", "关羽");
        prop.setProperty("003", "张飞");

        FileWriter fw = new FileWriter("idea_test1\\fw.txt");

        prop.store(fw,null);

        fw.close();

    }
}
