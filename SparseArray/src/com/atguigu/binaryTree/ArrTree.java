package com.atguigu.binaryTree;

public class ArrTree {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        Arr arr1 = new Arr(arr);
        //arr1.preList();
        //arr1.midList(0);
        arr1.lastList(0);
    }

}
class Arr{
    int[] arr;
    public Arr(int[] arr) {
        this.arr = arr;
    }
    public void preList(){
        preList(0);
    }
    public void preList(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        if(2*index+1<=arr.length-1){
            preList(2*index+1);
        }
        if(2*index+2<=arr.length-1){
            preList(2*index+2);
        }
    }
    public void midList(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
            return;
        }
        if(2*index+1<=arr.length-1){
            midList(2*index+1);
        }
        System.out.println(arr[index]);
        if(2*index+2<=arr.length-1){
            midList(2*index+2);
        }
    }
    public void lastList(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
            return;
        }
        if(2*index+1<=arr.length-1){
            lastList(2*index+1);
        }
        if(2*index+2<=arr.length-1){
            lastList(2*index+2);
        }
        System.out.println(arr[index]);
    }
}