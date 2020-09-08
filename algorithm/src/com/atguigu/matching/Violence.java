package com.atguigu.matching;

public class Violence {
    public static void main(String[] args) {
        String s1="hell wor hello hhhhh";
        String s2="hello-";
        int i = matching(s1, s2);
        System.out.println(i);
    }
    public static int matching(String s1,String s2){
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();
        int lenS1=str1.length;
        int lenS2=str2.length;
        int i=0;
        int j=0;
        while (i<lenS1&&j<lenS2){
            if(str1[i]==str2[j]){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        if(j==lenS2){
            return i-j+1;
        }else {
            return -1;
        }
    }
}
