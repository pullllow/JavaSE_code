package com.datastructure.minimumcostspanningtree;
/*
 *  @author changqi
 *  @date 2021/10/14 19:21
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };

        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, data, weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);

    }
}

//创建最小生成树->村庄的图
class MinTree {
    //创建图的邻接矩阵

    /**
     * @Description :
     * @Params :graph 图对象
     * @Params :verxs 图对应的顶点个数
     * @Params :data 图的各顶点的值
     * @Params :weight 图的邻接矩阵
     * @Return :
     */

    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @Description :
     * @Params :mGraph 图
     * @Params :v 表示从图的第几个顶点开始生成
     * @Return :
     */

    public void prim(MGraph mGraph, int v) {
        int[] visited = new int[mGraph.verxs];
        visited[v] = 1;
        int minLength = 10000;
        int l1 = -1;
        int l2 = -1;

        for (int k = 1; k < mGraph.verxs; k++) {
            for (int i = 0; i < mGraph.verxs; i++) {
                for (int j = 0; j < mGraph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minLength) {
                        minLength = mGraph.weight[i][j];
                        l1=i;
                        l2=j;
                    }
                }
            }
            System.out.println("边<"+mGraph.data[l1]+","+mGraph.data[l2]+">:"+minLength);
            visited[l2]=1;
            minLength=10000;
        }

    }

}

class MGraph {
    int verxs; //表示图的节点个数
    char[] data; //存放节点数据
    int[][] weight; //存放边，邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
