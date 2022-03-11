package com.datastructure.minimumcostspanningtree;
/*
 *  @author changqi
 *  @date 2021/10/18 18:57
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class  Kruskal {
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    private static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        char[] vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},

        };
        Kruskal kruskal = new Kruskal(vertexs, matrix);
        kruskal.print();

        EdgeData[] edge = kruskal.getEdge();
        System.out.println(Arrays.toString(edge));
        kruskal.sortEdgeData(edge);
        System.out.println(Arrays.toString(edge));
        EdgeData[] kruskal1 = kruskal.kruskal();
        //System.out.println(Arrays.toString(kruskal1));

    }

    public Kruskal(char[] vertexs, int[][] matrix) {
        this.edgeNum = 0;
        this.vertexs = new char[vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        this.matrix = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (this.matrix[i][j] < INF) {
                    edgeNum++;
                }
            }
        }
    }

    private EdgeData[] kruskal() {
        EdgeData[] mintree = new EdgeData[edgeNum];
        EdgeData[] edge = getEdge();
        sortEdgeData(edge);
        int[] ends = new int[vertexs.length];
        int index = 0;


        for (int i = 0; i < edge.length; i++) {
            int p1 = getPosition(edge[i].start);
            int p2 = getPosition(edge[i].end);

            int e1 = getEnd(ends, p1);
            int e2 = getEnd(ends, p2);

            if (e1 != e2) {
                ends[p1] = e2;
                mintree[index++] = edge[i];
            }
        }


        return mintree;
    }


    /**
     * @Description : 打印矩阵
     * @Params :
     * @Return :
     */
    private void print() {
        System.out.println("邻接矩阵为");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%-12d\t", matrix[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * @Description : 得到边数组
     * @Params :
     * @Return :
     */
    private EdgeData[] getEdge() {
        int index = 0;
        EdgeData[] edgeData = new EdgeData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] < INF) {
                    edgeData[index++] = new EdgeData(vertexs[i], vertexs[j], matrix[i][j]);
                }

            }
        }
        return edgeData;

    }


    /**
     * @Description : 冒泡排序对边进行重新排序
     * @Params :
     * @Return :
     */
    private void sortEdgeData(EdgeData[] edgeData) {
        for (int i = 0; i < edgeData.length - 1; i++) {
            for (int j = 0; j < edgeData.length - 1 - i; j++) {
                if (edgeData[j].weight > edgeData[j + 1].weight) {
                    EdgeData temp = edgeData[j];
                    edgeData[j] = edgeData[j + 1];
                    edgeData[j + 1] = temp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;

    }

    private int getEnd(int[] ends, int i) {
        if (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}


class EdgeData {
    public char start;
    public char end;
    public int weight;

    public EdgeData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "<" + start +
                ", " + end +
                ">=" + weight +
                '}';
    }
}



