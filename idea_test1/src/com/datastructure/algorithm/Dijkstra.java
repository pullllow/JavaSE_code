package com.datastructure.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/18 19:33
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class Dijkstra {

    private static int INF = 255;

    public static void main(String[] args) {
        char[] vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {INF, 5, 7, INF, INF, INF, 2},
                {5, INF, INF, 9, INF, INF, 3},
                {7, INF, INF, INF, 8, INF, INF},
                {INF, 9, INF, INF, INF, 4, INF},
                {INF, INF, 8, INF, INF, 5, 4},
                {INF, INF, INF, 4, 5, INF, 6},
                {2, 3, INF, INF, 4, 6, INF},

        };
        Graph graph = new Graph(vertexs, matrix);
        //graph.print();
        int[] dijkstra = dijkstra(graph,0);
        System.out.println(Arrays.toString(dijkstra));

    }

    /**
     * @Description dijkstra
     * @param graph
 * @param start
     * @return int[]
     **/
    public static int[] dijkstra(Graph graph, int start) {
        int[] alreadyArr = new int[graph.getEdgeNum()]; //判断节点是否访问过
        int[] preVisited = new int[graph.getEdgeNum()]; //存放每个节点的前驱结点
        int[] distance = new int[graph.getEdgeNum()];  //存放起始节点到目标节点的距离

        //初始化
        alreadyArr[start] = 1;

        for (int i = 0; i < graph.getEdgeNum(); i++) {
            distance[i] = INF;
            preVisited[i] = -1;

        }
        distance[start] = 0;
        int minIndex = INF;
        for (int i = 0; i < graph.getEdgeNum() - 1; i++) {
            for (int j = 0; j < graph.getEdgeNum(); j++) {
                if (distance[j] > distance[start]+ graph.getMatrix()[start][j]) {
                    distance[j] = distance[start]+ graph.getMatrix()[start][j];
                    preVisited[j] = start;
                }
            }
            minIndex = INF;
            for (int j = 0; j < graph.getEdgeNum(); j++){
                if(alreadyArr[j]==0 && minIndex > distance[j]){
                    minIndex = distance[j];
                    start = j;
                }
            }
            alreadyArr[start]=1;


        }

        return distance;
    }
}


 class Graph {
    private char[] vertex;
    private int[][] matrix;
    private int edgeNum;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = new char[vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            this.vertex[i] = vertex[i];
        }
        this.matrix = new int[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }

        }
        this.edgeNum = vertex.length;
    }

    public char[] getVertex() {
        return vertex;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getEdgeNum() {
        return edgeNum;
    }


    public void print() {
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%-12d\t", getMatrix()[i][j]);
            }
            System.out.println();
        }
    }


}
