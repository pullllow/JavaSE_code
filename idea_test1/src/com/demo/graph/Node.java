package com.demo.graph;
/*
 *  @author changqi
 *  @date 2021/12/3 16:23
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;

public class Node {
    public int val;
    public int in;
    public int out;

    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;

        nodes = new ArrayList<>();
        edges = new ArrayList<>();

    }
}
