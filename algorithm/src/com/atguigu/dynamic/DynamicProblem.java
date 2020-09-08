package com.atguigu.dynamic;

public class DynamicProblem {
    public static void main(String[] args) {
        int w[]={1,4,3};
        int value[]={1500,3000,2000};
        int v[][]=new int[w.length+1][5];
        int path[][]=v;
        for (int i = 1; i < v[0].length; i++) {
            v[0][i]=0;
        }
        for (int i = 1; i <v.length ; i++) {
            for (int j = 1; j <v[0].length ; j++) {
                if(w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
                    v[i][j]=Math.max(v[i-1][j],value[i-1]+v[i-1][j-w[i-1]]);
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.printf("%d \t",v[i][j]);
            }
            System.out.println();
        }
    }
}
