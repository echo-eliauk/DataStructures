package com.atguigu.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrChart {
    public static int[][] edges;
    public static ArrayList<String> vertexList;//存储顶点集合
    public static int numEdges;//边的数目
    public static boolean[] visited;
    public static void main(String[] args) {
        int n=5;//五条边
        chart(n);
        String  str[]={"A","B","C","D","E"};
        for (String i:str) {
            insertVertex(i);
        }
        addEdges(0,1);
        addEdges(0,2);
        addEdges(1,2);
        addEdges(1,3);
        addEdges(1,4);
        System.out.println(numEdges());
        list();
        //dfs();
        bfs();
    }
    //初始化
    public static void chart(int n){
        edges=new int[n][n];
        visited=new boolean[n];
        vertexList=new ArrayList<>(n);
        numEdges=0;
    }
    //显示各个顶点
    public static String getVertex(int i){
        return vertexList.get(i);
    }
    //添加顶点
    public static void insertVertex(String v1){
        vertexList.add(v1);
    }
    //显示图
    public static void list(){
        for (int[] value:edges) {
            System.out.println(Arrays.toString(value));
        }
    }
    //边的条数
    public static int numEdges(){
        return numEdges;
    }
    //顶点之间的边初始化
    public static void addEdges(int v1,int v2){
        edges[v1][v2]=1;
        edges[v2][v1]=1;
        numEdges++;
    }
    //获取当前节点的下一个节点
    public static int getNext(int i){
        for (int j = i+1; j <edges.length ; j++) {
            if(edges[i][j]>0){//有路
                return j;
            }
        }
        return -1;
    }
    //获取当前邻接节点的下一个邻接节点
    public static int getNextnext(int n,int m){
        for (int i = m+1; i < edges.length; i++) {
            if(edges[n][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历
    public static void dfs(int index){
        System.out.print(getVertex(index)+"->");
        visited[index]=true;
        int n=getNext(index);
        while(n!=-1){
            if(!visited[n]){//未访问
                dfs(n);
            }
            n=getNextnext(index,n);//访问了就接着访问下一个通路
        }
    }
    //遍历所有节点
    public static void dfs(){
        for (int i = 0; i <edges.length ; i++) {
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    //广度优先遍历
    public static void bfs(int index){
        System.out.print(getVertex(index)+"->");
        visited[index]=true;
        LinkedList list=new LinkedList();
        list.addLast(index);
        while(!list.isEmpty()){
            int u=(Integer) list.removeFirst();
            int v = getNext(u);
            while(v!=-1){
                if(!visited[v]){
                    visited[v]=true;
                    System.out.print(getVertex(v)+"->");
                    list.addLast(v);
                }
                v= getNextnext(u, v);
            }
        }
    }
    public static void bfs(){
        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                bfs(i);
            }
        }
    }
}
