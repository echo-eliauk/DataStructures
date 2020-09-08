package com.atguigu.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SheelSort {
    public static void main(String[] args) {
       /* int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);*/
       int arr[]={3,7,6,9,3,5,3};
        //sheel(arr);
        insert(arr);
       // System.out.println(Arrays.toString(arr));
   /*     Date date1=new Date();
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);*/
    }
    //交换法
    public static void sheel(int[] arr) {
        int temp = 0;
        int length=arr.length;
        while(length!=1){
            length=length/2;
            for (int i = length; i < arr.length; i++) {
                for (int j = i - length; j >= 0; j -= length) {
                    if (arr[j] >= arr[j + length]) {
                        temp = arr[j];
                        arr[j] = arr[j + length];
                        arr[j + length] = temp;
                    }
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
    }
    //移位发，也就是插入
    public static void insert(int[] arr){
        int length=arr.length;
        while(length!=1){
            length=length/2;
            for (int i = length; i <arr.length ; i++) {
                int j=i;
                int cur=arr[i];
                if(arr[j]<arr[j-length]){
                    while (j-length>=0&&cur<arr[j-length]){
                        arr[j]=arr[j-length];
                        j-=length;
                    }
                    arr[j]=cur;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
