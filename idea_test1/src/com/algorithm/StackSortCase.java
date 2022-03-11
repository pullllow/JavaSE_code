package com.algorithm;
/*
 *  @author changqi
 *  @date 2022/1/4 19:17
 *  @description
 *  @Version V1.0
 */

import java.util.Stack;

public class StackSortCase {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(7);
        stack.push(6);
        stack.push(4);
        stack.push(3);

        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(temp.isEmpty() || top<=temp.peek()){
                temp.push(top);
            } else {
                while(!temp.isEmpty()&&top>temp.peek() ) {
                    stack.push(temp.pop());
                }
                temp.push(top);
            }
        }

        while(!temp.isEmpty()){
            System.out.println(temp.peek());
            stack.push(temp.pop());
        }



    }
}
