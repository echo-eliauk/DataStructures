package com.atguigu.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 实质：将数组所有元素二分递归至只有一个元素的数组，然后将这一个一个的元素合并成一个有序数组
 */
public class MergetSort {
    public static void main(String[] args) {
        int arr[]={5,4,6,7,8,3,2,1};
        int[] temp=new int[arr.length];
        merget(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void merget(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;//一直二分直至left=mid;
            //向左遍历分割
            merget(arr,left,mid,temp);
            //向右遍历分割
            merget(arr,mid+1,right,temp);
            //合并
            add(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr 初始数组
     * @param left 下界
     * @param mid 中间索引
     * @param right 上界
     * @param temp 合并之后的数组
     */
    public static void add(int[] arr,int left,int mid,int right,int[] temp){
        int t=0;//temp数组的初始索引
        int i=left;
        int j=mid+1;
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            }else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //将剩余没有移动的元素全部移动到temp中
        while (i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        //将temp复制到arr
        t=0;
        int templeft=left;
        while (templeft<=right){
            arr[templeft]=temp[t];
            t++;
            templeft++;
        }
    }
}

