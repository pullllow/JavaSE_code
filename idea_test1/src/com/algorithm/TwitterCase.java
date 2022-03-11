package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/5 19:45
 *  @description 355. 设计推特
 *  @Version V1.0
 */

import java.util.*;

public class TwitterCase {
    public static void main(String[] args) {

    }
}

class Twitter {
/*
    private Map<Integer, Stack<Integer>> map;
    private Map<Integer,Integer> record;
    Stack<Integer> stack  = new Stack<Integer>(){

    };
    public Twitter() {
        this.map = new HashMap<Integer, Stack<Integer>>();
        this.record = new HashMap<Integer, Integer>();

    }

    public void postTweet(int userId, int tweetId) {
        record.put(tweetId,record.size()+1);
        if(map.containsKey(userId)){
            map.get(userId).push(tweetId);
        } else {
            Stack<Integer> stack  = new Stack<Integer>();
            stack.push(tweetId);
            map.put(userId,stack);
        }

    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> lists = new ArrayList<>();
        Stack<Integer> stack = map.get(userId).clone(){

        };
        while(!stack.empty()){
            lists.add(stack.pop());
        }
        return lists;

    }



    public void follow(int followerId, int followeeId) {
        Stack<Integer> stacker = map.get(followerId);
        //Stack<Integer> stackee = map.get(followeeId).clone();
        Stack<Integer> stack  = new Stack<Integer>();
        while(!stacker.empty()&&!stackee.empty()){
            if(record.get(stacker.peek())>record.get(stackee.peek())){
                stack.push(stacker.pop());
            } else {
                stack.push(stackee.pop());
            }
        }
        while(!stack.empty()){
            stacker.push(stack.pop());
        }

    }

    public void unfollow(int followerId, int followeeId) {
        Stack<Integer> stacker = map.get(followerId);
        //Stack<Integer> stackee = map.get(followeeId).clone();
        Stack<Integer> stack  = new Stack<Integer>();
        while(!stacker.empty()){
            if(stacker.peek()!=stackee.peek()){
                stack.push(stacker.pop());
            } else {
                stack.push(stacker.pop());
                stackee.pop();
            }
        }
        while(!stack.empty()){
            stacker.push(stack.pop());
        }
    }
    */
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */