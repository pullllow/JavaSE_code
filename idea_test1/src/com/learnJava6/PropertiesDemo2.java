package com.learnJava6;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo2 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("001", "刘备");
        prop.setProperty("002", "关羽");
        prop.setProperty("003", "张飞");

        System.out.println(prop.getProperty("001"));
        System.out.println(prop);

        Set<String> names = prop.stringPropertyNames();
        for (String key : names) {
            String value = prop.getProperty(key);
            System.out.println(key + "," + value);
        }

    }
}
