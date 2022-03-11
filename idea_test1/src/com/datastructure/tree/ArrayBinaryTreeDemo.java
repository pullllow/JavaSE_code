package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/6/7 18:35
 *  @description    顺序存储二叉树
 *  @Version V1.0
 */

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();


    }
}


class ArrayBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }


    public void preOrder(){
        this.preOrder(0);
    }


    /**
     * @Description : 顺序存储二叉树的前序遍历
     * @Params : index 数组的下标
     * @Return :
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能前序遍历");
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}