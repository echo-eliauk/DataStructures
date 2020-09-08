package com.atguigu.binaryTree;
//二叉树
public class BinaryTree1 {
    static int count=0;
    public static void main(String[] args) {
        Tree tree = new Tree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node1 = new HeroNode(2,"晁盖");
        HeroNode node2 = new HeroNode(3,"吴用");
        HeroNode node3 = new HeroNode(4,"武松");
        HeroNode node4 = new HeroNode(5,"花荣");
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);
        tree.setRoot(root);
        //前序
        tree.preList();
        tree.preDel(4);
        tree.preList();
      /*  //中序
        tree.midList();
        //后序
        tree.lastList();*/
    }
}
//树
class Tree{
    HeroNode root;//根节点
    public void setRoot(HeroNode root){
        this.root=root;
    }
    //前序遍历
    public void preList(){
        System.out.println("前序遍历：");
        if(root!=null){
            root.preList();
        }else{
            System.out.println("空树");
        }
    }
    //前序查找
    public HeroNode preSearch(int id){
        System.out.println("前序查找：");
        if(root!=null){
            return root.preSearch(id);
        }else{
            System.out.println("空树");
            return null;
        }
    }
    //前序删除
    public void preDel(int id){
        System.out.println("前序删除");
        if(root!=null){
            if(root.id==id){
                root=null;
            }else{
                root.preDel(id);
            }
        }else{
            System.out.println("空树");
        }
    }
    //中序遍历
    public void midList(){
        System.out.println("中序遍历：");
        if(root!=null){
            root.midList();
        }else{
            System.out.println("空树");
        }
    }
    //中序查找
    public HeroNode midSearch(int id){
        System.out.println("中序查找：");
        if(root!=null){
            return root.midSearch(id);
        }else{
            System.out.println("空树");
            return null;
        }
    }
    //后序遍历
    public void lastList(){
        System.out.println("后序遍历：");
        if(root!=null){
            root.lastList();
        }else{
            System.out.println("空树");
        }
    }
    //后序查找
    public HeroNode lastSearch(int id){
        System.out.println("后序查找：");
        if(root!=null){
            return root.lastSearch(id);
        }else{
            System.out.println("空树");
            return null;
        }
    }
}
//节点类
class HeroNode{
    int id;
    String name;
    HeroNode left;
    HeroNode right;
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
    //前序遍历 中->左->右
    public void preList(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preList();
        }
        if(this.right!=null){
            this.right.preList();
        }
    }
    //前序查找 中->左->右
    public HeroNode preSearch(int id){
        if(this.id==id){
            System.out.println(this.name);
            return this;
        }
        HeroNode node=null;
        if(this.left!=null){
            node=this.left.preSearch(id);
        }
        if(node!=null){
            return node;
        }
        if(this.right!=null){
            node=this.right.preSearch(id);
        }
        return node;
    }
    //前序删除
    public void preDel(int id){
        if(this.left!=null&&this.left.id==id){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.id==id){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.preDel(id);
        }
        if(this.right!=null){
            this.right.preDel(id);
        }
    }
    //中序遍历 左->中->右
    public void midList(){
        if(this.left!=null){
            this.left.midList();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midList();
        }
    }
    //中序查找 左->中->右
    public HeroNode midSearch(int id){

        HeroNode node=null;
        if(this.left!=null){
            node=this.left.midSearch(id);
        }
        if(node!=null){
            return node;
        }
        if(this.id==id){
            return this;
        }
        if(this.right!=null){
            node=this.right.midSearch(id);
        }
        return node;
    }
    //后序遍历 左->右->中
    public void lastList(){
        if(this.left!=null){
            this.left.lastList();
        }
        if(this.right!=null){
            this.right.lastList();
        }
        System.out.println(this);
    }
    //后序查找 左->右->中
    public HeroNode lastSearch(int id){
        HeroNode node=null;
        if(this.left!=null){
            node=this.left.lastSearch(id);
        }
        if(node!=null){
            return node;
        }
        if(this.right!=null){
            node = this.right.lastSearch(id);
        }
        if(node!=null){
            return node;
        }
        if(this.id==id){
            return this;
        }
        return node;
    }
}
