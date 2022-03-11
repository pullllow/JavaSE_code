package com.datastructure.algorithm;
/*
 *  @author changqi
 *  @date 2021/10/18 20:38
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class Floyd {
    private static int INF = 255;

    public static void main(String[] args) {
        char[] vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 5, 7, INF, INF, INF, 2},
                {5, 0, INF, 9, INF, INF, 3},
                {7, INF, 0, INF, 8, INF, INF},
                {INF, 9, INF, 0, INF, 4, INF},
                {INF, INF, 8, INF, 0, 5, 4},
                {INF, INF, INF, 4, 5, 0, 6},
                {2, 3, INF, INF, 4, 6, 0},

        };
        Group group = new Group(vertexs, matrix);
        group.floyd1();
        group.print();
//        group = new Group(vertexs, matrix);
//        group.floyd2();
//        group.print();
        //System.out.println(Arrays.toString(group.floyd()));

        //Graph graph = new Graph(vertexs, matrix);
        //graph.print();
        //int[] dijkstra = dijkstra(graph,0);
        //System.out.println(Arrays.toString(dijkstra));

    }
}

class Group {
    private char[] vertex;//存放顶点数组
    private int[][] dis; //存放顶点距离
    private int[][] pre; //保存到达目标节点的前驱结点


    public Group(char[] vertex, int[][] dis) {
        this.vertex = new char[vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            this.vertex[i] = vertex[i];
        }
        this.dis = new int[vertex.length][vertex.length];
        this.pre = new int[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                this.dis[i][j] = dis[i][j];
                this.pre[i][j] = i;
            }

        }
    }

    public void floyd1() {
        for(int mid=0;mid< vertex.length;mid++){
            for(int i =0;i< vertex.length;i++){
                for(int j=0;j<vertex.length;j++){
                    if(dis[i][j]>dis[i][mid]+dis[mid][j]){
                        pre[i][j] = pre[mid][j];
                        dis[i][j] = dis[i][mid]+dis[mid][j];
                    }
                }

            }
        }

        //return this.dis;

    }

    public void floyd2() {
        for(int mid=0;mid< vertex.length;mid++){
            for(int i =0;i< vertex.length;i++){
                for(int j=0;j<vertex.length;j++){
                    if(dis[i][j]>dis[i][mid]+dis[mid][j]){
                        pre[i][j] = pre[i][mid];
                        dis[i][j] = dis[i][mid]+dis[mid][j];
                    }
                }

            }
        }

        //return this.dis;

    }


    public void print(){
        for(int i =0;i< vertex.length;i++){
            for(int j=0;j<vertex.length;j++){
                System.out.printf("%-12d\t",dis[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.print('\n');
        System.out.print('\t');
        for(int i =0;i< vertex.length;i++){
            System.out.print(vertex[i]);
            System.out.print('\t');
        }
        System.out.println();
        for(int i =0;i< vertex.length;i++){
            System.out.print(vertex[i]);
            System.out.print('\t');
            for(int j=0;j<vertex.length;j++){
                System.out.print(vertex[pre[i][j]]);
                System.out.print('\t');
            }
            System.out.println();
        }

    }

}
