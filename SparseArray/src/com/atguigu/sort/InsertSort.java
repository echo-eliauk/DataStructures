package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);
        insert(arr);
        Date date1=new Date();
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);
        //System.out.println(Arrays.toString(arr));
    }
    public static void insert(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int cur=arr[i];//保留当前的值
            int index=i-1;//当前值的前一个索引
            //判断索引合理，且当前值小于当前索引的前面的值
            //一直内循环
            while(index>=0&&cur<arr[index]){
                arr[index+1]=arr[index];
                index--;
            }
            arr[++index]=cur;
        }
    }
}
