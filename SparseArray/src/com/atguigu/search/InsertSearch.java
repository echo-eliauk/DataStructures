package com.atguigu.search;
/*二分查找，递归*/

import java.util.ArrayList;
import java.util.List;

/**
 * 插值查找，与二分查找的区别是寻找mid的方法不一样
 */
public class InsertSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,1,41,15,16,17,18,19,20};
        List<Integer> list = test3(arr, 0, arr.length - 1, 4);
        System.out.println(list);
    }

    //有多个重复值的查找
    public static List<Integer> test3(int[] arr, int left, int right, int target){
        System.out.println("*******");
        if(left>right||target<arr[left]||target>arr[right]){
            return new ArrayList<Integer>();
        }
        int mid=left+(left+right)*(target+arr[left])/(arr[left]+arr[right]);
        if(arr[mid]<target){
            return test3(arr,mid+1,right,target);
        }
        else if(arr[mid]>target){
            return test3(arr,left,mid-1,target);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(mid);
            int temp=mid-1;
            while(true){
                if(temp<0||arr[temp]!=target){
                    break;
                }
                list.add(temp);
                temp--;
            }
            temp=mid+1;
            while(true){
                if(temp==arr.length||arr[temp]!=target){
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
