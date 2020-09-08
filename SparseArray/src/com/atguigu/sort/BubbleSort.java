package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            array[i]=(int)(Math.random()*80000);//[0,1000)
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);
        BubbleSort sort = new BubbleSort();
        sort.bubble(array);
        Date date1=new Date();
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);
    }
    private void list(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.printf(array[i]+"\t");
        }
        System.out.println();
    }
    //冒泡排序
    private void bubble(int[] arr){
        int t=0;
        for(int i=0;i<arr.length-1;i++){
            boolean flag=true;
            for(int j=i+1;j<arr.length;j++){//j=0;j<arr.length-i-1;j++
                if(arr[i]>arr[j]){
                    flag=false;
                    t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
