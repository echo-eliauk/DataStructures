package com.atguigu.test;

import java.util.*;

import java.util.Scanner;
public class A{
    public static void main(String[] args){
        int[] t={1,8,6,2,5,4,8,3,6};
        int i = maxArea(t);
        System.out.println(i);
    }

    public  static int maxArea(int[] height) {
        int len=height.length;
        int[] res=new int[len];
        int max=0;
        int num=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i==j){
                    if(j==len-1){
                        break;
                    }
                    j++;
                }
                if(height[i]<=height[j]){
                    num=Math.max(i-j,j-i);
                    max=Math.max(num,max);
                }
            }
            res[i]=max*height[i];
            num=0;
            max=0;
            if(i>0){
                if(res[0]<res[i]){
                    res[0]=res[i];
                }
            }
        }
        return res[0];
    }
    public static int largestRectangleArea (int[] height) {
        // write code here
        int len=height.length;
        int[] t=new int[len];
        int num=1;
        int s=0;
        int m=0;
        for(int i=0;i<len;i++){
            num=1;
            s=i+1;
            m=i-1;
            if(i==0){
                while(height[i]<=height[s]&&s<len-1){
                    num++;
                    s++;
                }
            }else if(i!=len-1){
                while(height[i]<=height[s]){
                    num++;
                    s++;
                    if(s>len-1){
                        break;
                    }
                }
                while(height[i]<=height[m]){
                    num++;
                    m--;
                    if(m<0){
                        break;
                    }
                }
            }else{
                while(height[i]<=height[m]&&m>=0){
                    m--;
                    num++;
                }
            }
            t[i]=num*height[i];
        }
        for(int i=1;i<len;i++){
            if(t[0]<t[i]){
                t[0]=t[i];
            }
        }
        return t[0];
    }
    public static int[] get(int t,int[] arr){
        int[] A=new int[t];
        int k=-1;
        for(int i=0;i<t;i++){
            for(int j=1;j<=1000000000;j=j*2){
                k++;
                if(arr[i]<j){
                    A[i]=k;
                    break;
                }
            }
            k=-1;
        }
        return A;
    }
    public static int test(int m,int n,int k){
        int[] A=new int[m];
        int[] B=new int[n];
        int[] C=new int[m*n];
        int t=0;
        int temp=0;
        if(m>n){
            for (int i = 1; i <=n ; i++) {
                A[i-1]=i;
                B[i-1]=i;
            }
            for(int i=n+1;i<=m;i++){
                A[i-1]=i;
            }
        }else{
            for (int i = 1; i <=m ; i++) {
                A[i-1]=i;
                B[i-1]=i;
            }
            for(int i=m+1;i<=n;i++){
                B[i-1]=i;
            }
        }
            for (int j = 0; j <m ; j++) {
                for (int l = 0; l <n ; l++) {
                    C[t]=A[j]*B[l];
                    t++;
                }
            }
        for (int i = 0; i <m*n-1 ; i++) {
            for (int j = i+1; j <m*n ; j++) {
                if(C[i]<C[j]){
                    temp=C[i];C[i]=C[j];C[j]=temp;
                }
            }
        }
        return C[k-1];
    }
}
