package com.atguigu.search;
/*二分查找，递归*/

import java.util.ArrayList;
import java.util.List;

public class MidSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,1,41,15,16,17,18,19,20};
        List<Integer> list = test2(arr, 0, arr.length - 1, 4);
        System.out.println(list);
    }
    public static int test(int[] arr, int left, int right, int target){
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if(arr[mid]<target){
            return test(arr,mid+1,right,target);
        }
        else if(arr[mid]>target){
            return test(arr,left,mid-1,target);
        }else{

            return mid;
        }
    }

    //有多个重复值的查找
    public static List<Integer> test2(int[] arr, int left, int right, int target){
        System.out.println("**********");
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        if(arr[mid]<target){
            return test2(arr,mid+1,right,target);
        }
        else if(arr[mid]>target){
            return test2(arr,left,mid-1,target);
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
