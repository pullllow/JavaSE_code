package com.demo.graph;
/*
 *  @author changqi
 *  @date 2021/12/3 16:24
 *  @description
 *  @Version V1.0
 */


public class Edge   {

    public int weight;

    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
