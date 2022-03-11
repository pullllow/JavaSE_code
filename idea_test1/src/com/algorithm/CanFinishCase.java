package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/1 20:15
 *  @description 207. 课程表
 *  @Version V1.0
 */

import java.util.*;

public class CanFinishCase {

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}};

        int numCourses = 2;

        System.out.println(canFinish(numCourses, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        if (numCourses == 1) {
            return true;
        }
        for (int i = 0; i < numCourses; i++) {
            graph.nodes.put(i, new Node(i));
        }

        HashMap<Integer,Integer> inMap = new HashMap<>();

        for (int[] pre : prerequisites) {
            Node toNode = graph.nodes.get(pre[0]);
            Node fromNode = graph.nodes.get(pre[1]);
            toNode.in++;
            inMap.put(pre[0],inMap.getOrDefault(pre[0],0)+1);
            fromNode.out++;

            fromNode.nexts.add(toNode);

            Edge edge = new Edge(pre[1], pre[0]);
            //fromNode.edges.add(edge);
            toNode.edges.add(edge);
            graph.edges.add(edge);

        }

        HashSet<Node> hasLearn = new HashSet<>();



        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            Node cur = graph.nodes.get(i);
            if (cur.in == 0) {

                queue.add(cur);
            }
        }


        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            hasLearn.add(cur);
            for(Node next: cur.nexts) {
                inMap.put(next.val,inMap.get(next.val)-1);
                if(inMap.get(next.val)==0){
                    queue.add(next);

                }
            }

        }
        return hasLearn.size() == numCourses;


    }


    public static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }


    }

    public static class Edge {
        public int from;
        public int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }

    }

    public static class Node {
        public int val;
        public int in;
        public int out;

        public List<Node> nexts;
        public List<Edge> edges;

        public Node(int val) {
            this.val = val;
            in = 0;
            out = 0;
            nexts = new ArrayList<Node>();
            edges = new ArrayList<Edge>();
        }
    }
}
