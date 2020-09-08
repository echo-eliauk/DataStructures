package com.atguigu.haffmanTrr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HaffmanTree {
    public static void main(String[] args) {
        int arr[]={5,3,6,9,7,1};
        Node node = haffmanTree(arr);
        node.preList(node);
    }
    public static Node haffmanTree(int[] arr){
        List<Node> list=new ArrayList<>();
        for (int value:arr) {
            list.add(new Node(value));
        }
        while (list.size()>1){
            Collections.sort(list);
            System.out.println(list);
            Node left=list.get(0);
            Node right=list.get(1);
            Node parent=new Node(left.value+right.value);
            parent.left=left;
            parent.right=right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }
}
class Node implements Comparable<Node>{
    int value;
    Node left;//左子节点
    Node right;//右子节点

    //前序遍历 中->左->右
    public void preList(Node node){
        System.out.println(node.value);
        if(node.left!=null){
            preList(node.left);
        }
        if(node.right!=null){
            preList(node.right);
        }
    }
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override//实现从小到大排序
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
