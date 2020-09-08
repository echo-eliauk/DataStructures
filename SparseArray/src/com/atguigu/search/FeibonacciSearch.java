package com.atguigu.search;

import java.util.Arrays;

public class FeibonacciSearch {
    private static int maxSize=20;
    public static void main(String[] args) {
        int arr[]={1,5,7,34,244,890};
        int index = test(arr, 0);
        System.out.println(index);
    }
    //构建斐波那契数列
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i <maxSize ; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    public static int test(int[] arr,int target){
        int mid=0;
        int[] f = fib();
        int k=0;
        int low=0;
        int height=arr.length-1;
        while(height>f[k]-1){
            k++;
        }
        //如果传过来的数组长度小于斐波那契数列的长度，就copy给temp，然后以零填充
        int[] temp= Arrays.copyOf(arr,f[k]-1);
        //以0填充换成以最高位填充
        for(int i=height+1;i<f[k]-1;i++){
            temp[i]=arr[height];
        }
        while (low<=height){
            mid=f[k-1]-1+low;
            if(target<temp[mid]){//在mid左边
                k--;
                height=mid-1;
            }else if(target>temp[mid]){
                k-=2;
                low=mid+1;
            }else{
                if(mid<=height){
                    return mid;
                }else {
                    return height;
                }
            }
        }
        return -1;
    }
}
