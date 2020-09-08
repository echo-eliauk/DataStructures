package com.atguigu.binarySortTree.avl;


public class BalanceBinaryTree {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        BalanceTree sortTree = new BalanceTree();
        for (int i = 0; i <arr.length ; i++) {
            sortTree.add(new Node(arr[i]));
        }
        sortTree.midOrder();
        System.out.println("根节点高度:"+sortTree.height());
        System.out.println("左子节点高度："+sortTree.getleft());
        System.out.println("右子节点高度："+sortTree.getright());
        //sortTree.leftRotate();
        /*System.out.println("左旋转之后");
        System.out.println("根节点高度:"+sortTree.height());
        System.out.println("左子节点高度："+sortTree.getleft());
        System.out.println("右子节点高度："+sortTree.getright());*/
    }
}

class BalanceTree{
    Node root;

    public Node getRoot() {
        return root;
    }

    //添加节点
    public void add(Node node){
        if(root!=null){
            root.add(node);
        }else{
            root=node;
            return;
        }
    }
    //中序遍历
    public void midOrder(){
        if(root!=null){
            root.midOrder();
        }else{
            System.out.println("空树");
            return;
        }
    }
    //删除节点
    public void delete(int value){
        if(root!=null){
            root.delete(value);
        }else{
            System.out.println("空树");
            return;
        }
    }
    //左节点高度
    public int getleft(){
        return root.getleft();
    }
    public int getright(){
        return root.getright();
    }
    public int height(){
        return root.height();
    }
    //左旋转
    public void leftRotate(){
        root.leftRotate();
    }
    //右旋转
    public void rightRotate(){
        root.rightRotate();
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    //顺序添加节点
    public void add(Node node){
        if(node==null){
            return;
        }
        if(this.value>node.value){
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else{
            if(this.right==null){
                this.right=node;
            }else
                this.right.add(node);
        }
        if(getright()-getleft()>1){
            //如果右子树的左子树大于右子树的右子树
            /*if(this.right.getright()<this.right.getleft()){
                right.rightRotate();
            }*/
            leftRotate();
        }
        if(getleft()-getright()>1){
            //如果左子树的右子树大于左子树的左子树
            /*if(this.left.getright()>this.left.getleft()){
               left.leftRotate();
            }*/
            rightRotate();
        }
    }
    //中序遍历
    public void midOrder(){
        System.out.println(this.value);
        if(this.left!=null){
            this.left.midOrder();
        }
        if(this.right!=null){
            this.right.midOrder();
        }
    }
    //查找节点
    public Node search(int value){
        if(this.value==value){
            return this;
        }else if(this.value>value){
            if(this.left==null){
                return null;
            }
            return this.left.search(value);
        }else{
            if(this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找节点的父节点
    public Node searchPar(int value){
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            if(this.left!=null&&this.value>value){
                return this.left.searchPar(value);
            }else if(this.right!=null&&this.value<=value){
                return this.right.searchPar(value);
            }else {
                return null;
            }
        }
    }
    //删除节点
    //三种情况：

    /**
     * 1.叶子节点，直接删除
     * 2.有一个子节点
     * 3.有两个字树
     * @param value
     */
    public void delete(int value){
        Node node = search(value);
        if(node==null){
            System.out.println("没有该节点");
            return;
        }
        Node parent = searchPar(value);
        if(parent==null){
            System.out.println("该节点没有父节点");
        }
        if(node.left==null&&node.right==null){//叶子节点
            if(parent.left==node){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }else if(node.left!=null&&node.right==null){//左子节点不为空，右子节点为空
            if(parent!=null){
                if(parent.left==node){
                    parent.left=node.left;
                }else{
                    parent.right=node.left;
                }
            }else{
                this.left=node;
            }
        }else if(node.right!=null&&node.left==null){
            if(parent.left==node){
                parent.left=node.right;
            }else{
                parent.right=node.right;
            }
        }else{//有两个子树
            //找到右子树最小的值，或左子树最大的值
            Node cur=node.right;
            Node temp=null;
            while(cur.left!=null){
                temp=cur;
                cur=cur.left;
            }
            node.value=cur.value;
            temp.left=cur.right;
        }
    }

    public int getright(){
        if(this.right==null){
            return 0;
        }else{
            return this.right.height();
        }
    }
    //当前节点左节点的高度
    public int getleft(){
        if(this.left==null){
            return 0;
        }else{
            return this.left.height();
        }
    }
    //返回当前节点的高度
    public int height(){
        return Math.max(this.left==null?0:this.left.height(),this.right==null?0:this.right.height())+1;
    }
    //左旋转
    public void leftRotate(){
        Node node=new Node(this.value);
        node.left=this.left;
        node.right=this.right.left;
        this.value=this.right.value;
        this.right=this.right.right;
        this.left=node;
    }
    //右旋转
    public void rightRotate(){
        Node node=new Node(this.value);
        node.right=this.right;
        node.left=this.left.right;
        this.value=this.left.value;
        this.left=this.left.left;
        this.right=node;
    }
}

