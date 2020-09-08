package com.atguigu.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序：又称桶排序
 */
public class RadixSort{
    public static void main(String[] args) {
        //int arr[]={4,4,4,26,783,9,0,4,8990};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);
        test(arr);
        Date date1=new Date();
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);
    }
    public static void test(int[] arr){
        //先找出最大值的位数
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int len=(max+"").length();
        //定义一个二维数组，十个桶，每个桶里有什么元素，看成是个一位数组
        int[][] tom=new int[10][arr.length];
        //定义每个桶里元素的个数
        int[] index=new int[10];
        int temp=0;
        //把arr数组中的元素放入桶中
        for(int x=0,n=1;x<=len;x++,n*=10){
            for(int i=0;i<arr.length;i++){
                int t=arr[i]/n % 10;
                tom[t][index[t]]=arr[i];
                index[t]++;
            }
            //将桶中的元素放回arr中
            int k=0;
            for (int i=0;i<index.length;i++){//遍历十个桶
                //i号桶中有元素
                if(index[i]!=0){
                    for(int j=0;j<index[i];j++){
                        arr[k++]=tom[i][j];
                    }
                }
                //处理之后要对各桶数据清零!!!不然后继就会越界
                index[i]=0;
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    public static void radix(int[] arr){
        //定义一个二维数组，十个桶，每个桶里有什么元素，看成是个一位数组
        int[][] tom=new int[10][arr.length];
        //定义每个桶里元素的个数
        int[] index=new int[10];
        int temp=0;
        //把arr数组中的元素放入桶中
        for(int i=0;i<arr.length;i++){
            int t=arr[i]%10;
            tom[t][index[t]]=arr[i];
            index[t]++;
        }
        //将桶中的元素放回arr中
        int k=0;
        for (int i=0;i<index.length;i++){//遍历十个桶
            //i号桶中有元素
            if(index[i]!=0){
                for(int j=0;j<index[i];j++){
                    arr[k++]=tom[i][j];
                }
            }
            //处理之后要对各桶数据清零!!!不然后继就会越界
            index[i]=0;
        }
        System.out.println(Arrays.toString(arr));/*
        for(int i=0;i<10;i++)
            for(int j=0;j<arr.length;j++){
                tom[i][j]=0;
            }
        for(int i=0;i<index.length;i++)
            index[i]=0;*/
        //第二次桶排序
        //把arr数组中的元素放入桶中
        for(int i=0;i<arr.length;i++){
            int t=arr[i]/10%10;
            tom[t][index[t]]=arr[i];
            index[t]++;
        }
        //将桶中的元素放回arr中
        k=0;
        for (int i=0;i<index.length;i++){//遍历十个桶
            //i号桶中有元素
            if(index[i]!=0){
                for(int j=0;j<index[i];j++){
                    arr[k]=tom[i][j];
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
