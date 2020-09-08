package com.atguigu.binaryTree.clue;

/**
 * 线索二叉树
 */
public class ClueBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node1 = new HeroNode(2,"晁盖");
        HeroNode node2 = new HeroNode(3,"吴用");
        HeroNode node3 = new HeroNode(4,"武松");
        HeroNode node4 = new HeroNode(5,"花荣");
        HeroNode node5 = new HeroNode(6,"卢俊义");
        HeroNode node6 = new HeroNode(7,"李逵");
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        tree.setRoot(root);
        tree.clue(root);
        HeroNode left = root.getLeft();
        HeroNode right = root.getRight();
        //System.out.println(left);
        //System.out.println(right);
        tree.midList();
       /*tree.preClue(root);
        HeroNode left = node3.getLeft();
        HeroNode right = node3.getRight();
        System.out.println(left);
        System.out.println(right);*/
    }
}

class Tree{
    HeroNode root;//根节点
    HeroNode pre=null;//当前节点的前一个节点
    public void setRoot(HeroNode root){
        this.root=root;
    }
    //中序线索化二叉树
    public void clue(HeroNode node){
        if(node==null){
            System.out.println("不能线索化");
            return;
        }
        //向左线索化
        if(node.left!=null){
            clue(node.getLeft());
        }
        //当前节点线索化
        //当前节点的左节点，右节点
        if(node.left==null){
            node.setLeft(pre);
            node.setLeftNum(1);
        }
        if(pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightNum(1);
        }
        pre=node;
        //向右线索化
        if(node.right!=null){
            clue(node.getRight());
        }
    }
    //中序遍历
    public void midList(){
        HeroNode node=root;
        while(node!=null){
            while(node.getLeftNum()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while(node.getRightNum()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
            //System.out.println(node);
        }
    }
    //前序线索化二叉树
    public void preClue(HeroNode node){
        if(node==null){
            return;
        }
        //当前节点线索化
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftNum(1);
        }
        if(node.getRight()==null){
            node.setRight(pre.getRight());
            node.setRightNum(1);
        }
        pre=node;
        //当前节点左节点
        if(node.getLeft()!=null){
            preClue(node.getLeft());
        }
        //当前节点右节点
        if(node.getRight()!=null){
            preClue(node.getRight());
        }
    }
}
//节点类
class HeroNode{
    int id;
    String name;
    HeroNode left;
    HeroNode right;
    int leftNum;
    int rightNum;

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

