package com.datastructure.tree;
/*
 *  @author changqi
 *  @date 2021/6/7 19:26
 *  @description 线索化二叉树
 *  @Version V1.0
 */

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(2, "jack");
        HeroNode node3 = new HeroNode(3, "smith");
        HeroNode node4 = new HeroNode(4, "mary");
        HeroNode node5 = new HeroNode(5, "king");
        HeroNode node6 = new HeroNode(6, "dim");
        HeroNode node7 = new HeroNode(7, "white1");
        HeroNode node8 = new HeroNode(8, "white2");
        HeroNode node9 = new HeroNode(9, "white3");
        HeroNode node10 = new HeroNode(10, "white4");
        HeroNode node11 = new HeroNode(11, "white5");
        HeroNode node12 = new HeroNode(12, "white6");


        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);
        node4.setRight(node9);
        node5.setLeft(node10);
        node6.setRight(node11);
        node7.setLeft(node12);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        //threadedBinaryTree.threadedPreNodes(root);
        /*
        threadedBinaryTree.threadedInfixNodes();
        threadedBinaryTree.threadedInfixList();*/
        /*threadedBinaryTree.threadedPreNodes();
        threadedBinaryTree.threadedPreList();*/
        threadedBinaryTree.threadedPostNodes();
        threadedBinaryTree.threadedPostList();
        System.out.println("------------");
        threadedBinaryTree.threadedPostLinearList();
        System.out.println("------------");
        threadedBinaryTree.list();
        //System.out.println(node3.getRight());

    }
}


class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，创建要给指向当前节点的前驱结点的指针
    //在递归线索化时，pre总是保留前一个节点
    private HeroNode pre = null;


    public void threadedPostNodes() {
        this.threadedPostNodes(root);
    }

    public void threadedInfixNodes() {
        this.threadedInfixNodes(root);
    }

    public void threadedPreNodes() {
        this.threadedPreNodes(root);
    }


    public void threadedPostList() {
        this.threadedPostList(root);
    }

    //遍历前序线索化二叉树的方法
    public void threadedPreList() {
        /*HeroNode node = root;
        while (node != null) {
            System.out.println(node);
            if (node.getLeftType() == 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }*/

        //!!!!!!!!!!
        HeroNode node = root;
        while (node != null) {
            System.out.println(node);
            if(node.getLeftType()==0){
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
    }


    //遍历中序线索化二叉树的方法
    public void threadedInfixList() {
        /*HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }*/


        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);

            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();

        }
    }

    //遍历后序线索化二叉树的方法 递归的方法
    public void threadedPostList(HeroNode node) {
        if (node.getLeftType() == 0) {
            threadedPostList(node.getLeft());
        }
        if (node.getRightType() == 0) {
            threadedPostList(node.getRight());
        }
        System.out.println(node);
    }


    //遍历后序线索化二叉树的方法，线性循环方法
    public void threadedPostLinearList() {
        /*HeroNode node = root;

        while((node!=null)&&(node.getLeftType()==0)){
            node = node.getLeft();
        }

        while(node!=null){
            if(node.getRightType()==1){
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                if(node.getRight()==pre){
                    System.out.println(node);
                    if(node == root){
                        return;
                    }
                    pre = node;
                    node = node.getParent();

                } else {
                    node = node.getRight();
                    while((node!=null)&&(node.getLeftType()==0)){
                        node = node.getLeft();
                    }
                }

            }
        }*/

        HeroNode node = root;
        while ((node != null) && (node.getLeftType() == 0)) {
            node = node.getLeft();
        }

        while (node != null) {
            if (node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                if (node.getRight() == pre) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {
                    node = node.getRight();
                    while ((node != null) && (node.getLeftType() == 0)) {
                        node = node.getLeft();
                    }
                }
            }
        }

    }

    public void list() {
        HeroNode node = root;
        while ((node != null) && (node.getLeftType() == 0)) {
            node = node.getLeft();
        }

        while (node != null) {
            if (node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                if (node.getRight() == pre) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {
                    node = node.getRight();
                    while ((node != null) && (node.getLeftType() == 0)) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }


    //二叉树进行前序线索化的方法
    public void threadedPreNodes(HeroNode node) {
       /* if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeftType(1);
            node.setLeft(pre);

        }
        if ((pre != null) && (pre.getRight() == null)) {
            pre.setRightType(1);
            pre.setRight(node);

        }
        pre = node;

        if (node.getLeftType() == 0) {
            threadedPreNodes(node.getLeft());
        }
        if (node.getRightType() == 0) {
            threadedPreNodes(node.getRight());
        }*/

        if(node==null){
            return;
        }
        if(node.getLeft()==null){
            node.setLeftType(1);
            node.setLeft(pre);
        }
        if((pre!=null)&&(pre.getRightType()==0)){
            pre.setRightType(1);
            pre.setRight(node);
        }
        node = pre;
        if(node.getLeftType()==0){
            threadedPreNodes(node.getLeft());
        }
        if(node.getRightType()==0){
            threadedPreNodes(node.getRight());
        }


    }

    //二叉树进行中序线索化的方法
    public void threadedInfixNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        //1.线索化左子树
        threadedInfixNodes(node.getLeft());

        //2.线索化当前节点
        //2.1 处理当前节点的前驱节点
        if (node.getLeft() == null) {
            node.setLeftType(1);
            node.setLeft(pre);


        }
        //2.2 处理上一节点的后继节点
        if ((pre != null) && (pre.getRight() == null)) {
            pre.setRightType(1);
            pre.setRight(node);

        }
        //2.3 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;
        //线索化右子树
        threadedInfixNodes(node.getRight());
    }


    //二叉树进行后序线索化的方法
    public void threadedPostNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftType() == 0) {
            threadedPostNodes(node.getLeft());
        }
        if (node.getRightType() == 0) {
            threadedPostNodes(node.getRight());
        }

        if (node.getLeft() == null) {
            node.setLeftType(1);
            node.setLeft(pre);

        }
        if ((pre != null) && (pre.getRight() == null)) {
            pre.setRightType(1);
            pre.setRight(node);
        }
        pre = node;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空，无法前序遍历");
        } else {
            this.root.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空，无法中序遍历");
        } else {
            this.root.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root == null) {
            System.out.println("二叉树为空，无法后续遍历");
        } else {
            this.root.postOrder();
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.preOrderSearch(no);
        }
    }

    //前序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.infixOrderSearch(no);
        }
    }

    //前序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.postOrderSearch(no);
        }
    }

    //删除相应节点
    public void delNode(int no) {
        if (this.root == null) {
            System.out.println("该二叉树为空树");
        } else if (this.root.getNo() == no) {
            this.root = null;
        } else {
            this.root.delNode(no);
        }

    }


}
