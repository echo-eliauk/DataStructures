package com.atguigu.sparse;

import java.util.Arrays;

public class SparseArray {
    public static void main(String[] args) {
        int iniArray[][]=new int[11][11];
        iniArray[1][2]=1;
        iniArray[2][3]=2;
        //输出原始数组
        System.out.println("打印原始数组");
        for(int[] row:iniArray){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //求出数组有值的总数
        int sum=0;
        for(int i=0;i<11;i++)
            for(int j=0;j<11;j++){
                if(iniArray[i][j]!=0){
                    sum++;
                }
            }
        //System.out.println(sum);
        //定义稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //遍历二维数组，将非零的值放入稀疏数组中

        int count=0;
        for(int i=0;i<11;i++)
            for(int j=0;j<11;j++){
                if(iniArray[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=iniArray[i][j];
                }
            }
        //输出稀疏数组
        System.out.println("打印稀疏数组");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        //稀疏数组转换成二维数组
        int newArr[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){
            newArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("打印新数组");
        for(int[] row:newArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
