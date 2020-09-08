package com.atguigu.hanoita;

public class HanoitaGame {
    public static void main(String[] args) {
        hanoita(3,'a','b','c');
    }
    //将num从a移动到c
    public static void hanoita(int num,char a,char b,char c){
        if(num==1){
            System.out.println("第1个从 "+a+"->"+c);
        }else{
            //将a分成两部分，num-1 和1，
            //将num-1移动到b,
            hanoita(num-1,a,c,b);
            //将num移动到c
            System.out.println("第"+ num +"个从 "+a+"->"+c);
            //将b的num-1移动到c
            hanoita(num-1,b,a,c);
        }
    }
}
