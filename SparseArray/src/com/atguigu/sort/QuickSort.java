package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        //int arr[]={10,7,8,0,-9,3,5,7,5,4,6,3};
        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);
        sort(arr,0,arr.length-1);
        Date date1=new Date();
        String s1 = simpleDateFormat.format(date1);
        System.out.println(s1);
        //System.out.println(Arrays.toString(arr));
    }
    public static void quick(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int middle=arr[(left+right)/2];
        int temp=0;
        while (l<r){
            while (arr[l]<middle){
                l++;
            }
            while (arr[r]>middle){
                r--;
            }
            if(l>=r){
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //如果没有这个判断就会死循环
            if(arr[l]==middle){
                l++;
            }
            if(arr[r]==middle){
                r--;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if (right>r){
            quick(arr,l,right);
        }
        if(left<l){
            quick(arr,left,r);
        }
    }

    //以第一个数作为基准
    public static int getI(int[] arr,int left,int right){
        int low=arr[left];
        while(left<right){
            while (left<right&&arr[right]>=low){
                right--;
            }
            if(left<right){
                arr[left]=arr[right];
            }
            while(left<right&&arr[left]<=low){
                left++;
            }
            if(left<right){
                arr[right]=arr[left];
            }
        }
        arr[left]=low;
        return left;
    }
    public static void sort(int[] arr,int left,int right){
        if(left<right){
            int i=getI(arr,left,right);
            sort(arr,left,i-1);
            sort(arr,i+1,right);
        }
    }
}
