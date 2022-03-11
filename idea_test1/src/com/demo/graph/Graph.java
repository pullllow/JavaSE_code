package com.demo.graph;
/*
 *  @author changqi
 *  @date 2021/12/3 16:23
 *  @description
 *  @Version V1.0
 */

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
