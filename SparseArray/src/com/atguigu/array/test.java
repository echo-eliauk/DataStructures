package com.atguigu.array;

import java.util.*;


public class test{
    public static void main(String[] args) {
        solution solution = new solution();
        int[] A={1,3};
        int a=1;
        int[] ints = solution.searchRange(A, a);
        System.out.println(ints);
    }
}
class solution {
    public int[] searchRange (int[] A, int target) {
        int[] B=new int[2];
        int j=0;
        int t=0;
        B[1]=-1;
        // write code here
        for(int i=0;i<A.length;i++){
            if(A[i]==target){
                t++;
                j=i;
            }
            if(A[i]>target){
                B[1]=i-1;
                break;
            }
        }
        if(t==0){
            B[0]=-1;
            B[1]=-1;
            return B;
        }
        if(B[1]==-1){
            B[1]=j;
            B[0]=j-t+1;
            return B;
        }
        B[0]=B[1]-t+1;
        return B;
    }
}