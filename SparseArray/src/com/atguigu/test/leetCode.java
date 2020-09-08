package com.atguigu.test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class leetCode {
    public static void main(String[] args) {
        //int i = NumberOf1Between1AndN_Solution(55);
        int i = StrToInt("+54");
        System.out.println(i);
        //System.out.println(i);
        int[] A={1,3,5};
        int t=A.length;
    }
    public  static int StrToInt(String str) {
        int i = str.length();
        int sum=0;
        int t=1;
        boolean flag=false;
        char[] chars = str.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if(chars[j]<48||chars[j]>57){
                i--;
                if(j==0){
                    if(chars[j]==43){
                        continue;
                    }else if(chars[j]==45){
                        flag=true;
                        continue;
                    }else{
                        return 0;
                    }
                }else
                    return 0;
            }
            for (int k = 1; k <i ; k++) {
                t=t*10;
            }
            sum=sum+(chars[j]-48)*t;
            t=1;
            i--;
        }
        if(flag==true){
            sum=-sum;
        }
        return sum;
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if (s.contains("1")) {
                for (int j = 0; j < s.length(); j++) {
                    if(s.charAt(j)=='1'){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
