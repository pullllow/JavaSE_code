package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/4 18:43
 *  @description 146. LRU 缓存机制
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheCase {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);

    }
}


class LRUCache {
    private int capacity;
    private int flag;
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> numOfUse; //

    public LRUCache(int capacity) {
        this.flag = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        //this.numOfUse = new HashMap<>(capacity);
        this.numOfUse = new LinkedList<>();

    }

    public int get(int key) {
        if(this.cache.containsKey(key)){
            //使用更新
            this.numOfUse.remove(this.numOfUse.indexOf(key));
            this.numOfUse.offerLast(key);
            return this.cache.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            this.cache.put(key,value);
            this.numOfUse.remove(this.numOfUse.indexOf(key));
            this.numOfUse.offerLast(key);
        } else{
            if(flag<this.capacity){
                //未满直接存放
                flag++;
                this.cache.put(key,value);
                this.numOfUse.addLast(key);
            } else {
                //已满查找
                this.cache.remove(this.numOfUse.pollFirst());
                this.cache.put(key,value);
                this.numOfUse.addLast(key);

            }

        }


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */