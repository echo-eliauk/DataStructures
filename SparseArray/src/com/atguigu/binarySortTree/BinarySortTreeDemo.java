package com.atguigu.binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr={10,5};
        BinarySortTree sortTree = new BinarySortTree();
        for (int i = 0; i <arr.length ; i++) {
            sortTree.add(new Node(arr[i]));
        }
        sortTree.midOrder();
        sortTree.delete(10);
        System.out.println("----------");
        sortTree.midOrder();
    }
}
class BinarySortTree{
    Node root;
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
}
