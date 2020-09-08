package com.atguigu.test;


import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int[] t={-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        int i = threeSumClosest(t, 0);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int len=nums.length;
        if(len==3){
            return nums[0]+nums[1]+nums[2];
        }
        int t=len-3;
        int[] res=new int[(len*(len-1)*(len-2))/6];
        int m=0,n=0;
        int x=0,y=0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    res[m]=nums[i]+nums[j]+nums[k];
                    m++;
                }
            }
        }
        for (int i = 0; i < res.length-1; i++) {
            for (int j = i+1; j <res.length ; j++) {
                if(res[i]<res[j]){
                    n=res[i];res[i]=res[j];res[j]=n;
                }
            }
        }
        for (; y <res.length ; y++) {
            if(res[0]<=target){
                x=res[y];
                break;
            }
            if(y<res.length-1&&res[y]>=target&&res[y+1]<=target){
                if(res[y]-target>target-res[y+1]){
                    x=res[y+1];
                }else {
                    x=res[y];
                }
                break;
            }
        }
        if(y==res.length){
            x=res[y-1];
        }
        return x;
    }
}

