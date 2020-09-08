package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序，每一次都将最小的拿出来
 */
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);
        ChooseSort sort = new ChooseSort();
        sort.choose(arr);
        Date date1=new Date();
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);
    }
    private void choose(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int index=i;
            int min=arr[index];
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<min){
                    min=arr[j];
                    index=j;
                }
            }
            if(index!=i){
                arr[index]=arr[i];
                arr[i]=min;
                //System.out.printf("第%d次循环------------\n",i);
                //System.out.println(Arrays.toString(arr));
            }
        }
    }
}
