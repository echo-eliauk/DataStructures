package com.atguigu.array;

public class NewArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a=new int[10];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        a[4]=5;
        a[5]=6;
        solution.reOrderArray(a);
    }
}
class Solution {
    public void reOrderArray(int [] array) {
        int[] a=new int[array.length];
        int j=0;
        int k=array.length/2;
        for(int i=0;i<array.length;i++){
            if(array[i]/2!=0){
                    a[j]=array[i];
                     System.out.println("---"+a[j]+"==="+array[i]);
                     j++;
                }
            else{
                    a[k]=array[i];
                System.out.println("++++"+a[k]+"==="+array[i]);
                    k++;
            }
        }
    }
}
