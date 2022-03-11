package com.datastructure.tree;


public class BinaryTreeDemo1 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"songjiang");
        HeroNode node2 = new HeroNode(2,"wuyong");
        HeroNode node3 = new HeroNode(3,"lujunyi");
        HeroNode node4 = new HeroNode(4,"linchong");
        HeroNode node5 = new HeroNode(5,"guansheng");

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        System.out.println("前序遍历");//12354
        binaryTree.preOrder();
        System.out.println("中序遍历");//21534
        binaryTree.infixOrder();
        System.out.println("后序遍历");//25431
        binaryTree.postOrder();

        System.out.println("-------------");
        System.out.println(binaryTree.preOrderSearch(2));
        System.out.println(binaryTree.postOrderSearch(3));
        System.out.println(binaryTree.infixOrderSearch(7));


        System.out.println("----------");
        System.out.println("删除前，前序遍历");//12354
        binaryTree.preOrder();
        binaryTree.delNode(4);

        System.out.println("删除4节点后，前序遍历");//12354
        binaryTree.preOrder();


    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if(this.root==null){
            System.out.println("二叉树为空，无法前序遍历");
        } else {
            this.root.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.root==null){
            System.out.println("二叉树为空，无法中序遍历");
        } else {
            this.root.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.root==null){
            System.out.println("二叉树为空，无法后续遍历");
        } else {
            this.root.postOrder();
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if(this.root==null){
            return null;
        } else {
            return this.root.preOrderSearch(no);
        }
    }

    //前序遍历查找
    public HeroNode infixOrderSearch(int no){
        if(this.root==null){
            return null;
        } else {
            return this.root.infixOrderSearch(no);
        }
    }

    //前序遍历查找
    public HeroNode postOrderSearch(int no){
        if(this.root==null){
            return null;
        } else {
            return this.root.postOrderSearch(no);
        }
    }

    //删除相应节点
    public void delNode(int no){
        if(this.root==null){
            System.out.println("该二叉树为空树");
        } else if(this.root.getNo()==no){
            this.root=null;
        } else{
            this.root.delNode(no);
        }

    }
}


class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private HeroNode parent;


    public HeroNode getParent() {
        return parent;
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    private int leftType; //leftType=0表示指向的是左子树，leftType=1表示指向的是前驱节点
    private int rightType;//rightType=0表示指向的是右子树，leftType=1表示指向的是后继节点

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
        if(this.leftType==0){
            left.setParent(this);
        }
    }

    public void setRight(HeroNode right) {
        this.right = right;
        if(this.rightType==0){
            right.setParent(this);
        }
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    /**
     * @Description : 前序遍历
     * @Params :
     * @Return :
     */

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }

    /**
     * @Description : 中序遍历
     * @Params :
     * @Return :
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * @Description : 后序遍历
     * @Params :
     * @Return :
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }

    /**
     * @Description : 前序遍历查找
     * @Params : no 查找no
     * @Return : 如果找到返回该Node,否则返回null
     */

    public HeroNode preOrderSearch(int no){
        if(this.no==no){
            return this;

        }
        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;


    }

    /**
     * @Description : 中序遍历查找
     * @Params : no 查找no
     * @Return : 如果找到返回该Node,否则返回null
     */

    public HeroNode infixOrderSearch(int no){

        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }

        if(this.no==no){
            return this;

        }
        if(this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;


    }

    /**
     * @Description : 中序遍历查找
     * @Params : no 查找no
     * @Return : 如果找到返回该Node,否则返回null
     */

    public HeroNode postOrderSearch(int no){

        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }

        if(resNode!=null){
            return resNode;
        }

        if(this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }

        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;

        }

        return resNode;
    }

    //根据编号删除节点
    //如果删除的节点是叶子节点，则删除该节点
    //如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){
        if((this.left!=null)&&(this.left.no==no)){
            this.left = null;
            return;
        }
        if((this.right!=null)&&(this.right.no==no)){
            this.right = null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}
