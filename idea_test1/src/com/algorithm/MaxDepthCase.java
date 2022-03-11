package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/21 16:08
 *  @description 559. N 叉树的最大深度
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxDepthCase {
    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> l1 = new ArrayList<>();
        l1.add(n5);
        l1.add(n6);
        Node n3 = new Node(3,l1);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        List<Node> l2 = new ArrayList<>();
        l2.add(n3);
        l2.add(n2);
        l2.add(n4);
        Node n1 = new Node(1,l2);
        System.out.println(maxDepth(n1));
    }


    public static int maxDepth(Node root) {

        if(root==null){
            return 0;
        }
        return backTrack(root,01);



    }


    public static int backTrack(Node root,int dep){
        if(root==null){
            return dep;
        }
        List<Node> node = root.children;
        if(node==null){
            return dep;
        }
        Iterator<Node> ite = node.iterator();
        int max = 0;
        while(ite.hasNext()){
            max = Math.max(max,backTrack(ite.next(),01)+dep);
        }
        return max;

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};