package com.atguigu.matching;

import java.util.Arrays;

public class KmpSearch {
    public static void main(String[] args) {
        String s1="abc aba abcabb abcde";
        String s2="abcab";
        int[] next = kmpNext(s2);
        int index = kmp(s1, s2, next);
        System.out.println(index);
    }
    public static int kmp(String s1,String s2,int[] next){
        for (int i = 0,j=0; i <s1.length() ; i++) {
            while(j>0&&s1.charAt(i)!=s2.charAt(j)){
                j=next[j-1];
            }
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if(j==s2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    //获取子串匹配值表
    public static int[] kmpNext(String s2){
        int next[]=new int[s2.length()];
        next[0]=0;
        for (int i = 1,j=0; i <s2.length() ; i++) {
            while(j>0&&s2.charAt(i)!=s2.charAt(j)){
                j=next[j-1];
            }
            if(s2.charAt(i)==s2.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
