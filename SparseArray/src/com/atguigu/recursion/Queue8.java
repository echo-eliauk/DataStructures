package com.atguigu.recursion;

public class Queue8 {
    int max=8;//八皇后
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        Queue8 queue = new Queue8();
        queue.add(0);
        System.out.println("count:"+count);
    }
    //往数组中加入皇后
    private void add(int n){
        if(n==max){
            print();
            return;
        }
        //遍历所有的列
        for (int i = 0; i <max ; i++) {
            array[n]=i;
            if(conflict(n)){
                add(n+1);
            }
        }
    }
    //判断是否冲突 传入第n个皇后,从0开始
    //false便是冲突
    private boolean conflict(int n){
        //遍历前面n-1个元素，判断是否冲突
        for (int i = 0; i <n ; i++) {
            //array[i]==array[n] 在同一列
            //Math.abs(array[n]-array[i])==Math.abs(n-i)在同一对角线上
            if(array[i]==array[n]||Math.abs(array[n]-array[i])==Math.abs(n-i)){
                return false;
            }
        }
        return true;
    }
    //打印
    private void print(){
        count++;
        for (int i = 0; i <max ; i++) {
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
}
