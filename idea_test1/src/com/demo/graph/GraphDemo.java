package com.demo.graph;
/*
 *  @author changqi
 *  @date 2021/12/3 16:20
 *  @description
 *  @Version V1.0
 */

import java.util.*;

public class GraphDemo {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nodes) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.val);
                    break;
                }
            }
        }
    }

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.val);
            for (Node next : cur.nodes) {
                if (!map.contains(next)) {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }

}

