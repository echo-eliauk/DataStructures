package com.atguigu.binaryTree;

import com.atguigu.array.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        //int arr[]={1,5,8,4,5,8,9,-1,10};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = formatter.format(date);
        System.out.println(format);
        test(arr);
        Date date1=new Date();
        String format1 = formatter.format(date1);
        System.out.println(format1);
        //System.out.println(Arrays.toString(arr));

    }
    public static void test(int[] arr){
        int temp=0;

        for (int i = arr.length; i >0 ; i--) {
            for (int j = arr.length/2-1; j >=0 ; j--) {
                sort(arr,j,i);
            }
            temp=arr[i-1];
            arr[i-1]=arr[0];
            arr[0]=temp;
        }
    }
    public static void sort(int[] arr,int i,int length){
        int temp=arr[i];
        for(int j=2*i+1;j<length;j=j*2+1){
            if(j+1<length&&arr[j]<arr[j+1]){
                j++;
            }
            if(arr[j]>arr[i]){
                arr[i]=arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}
