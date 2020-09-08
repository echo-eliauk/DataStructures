package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        birld birld = new birld();
        animals l1 = new birld();
        l1.shout();
        birld.eat();
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.get(1);
        Map<Integer, String> map = new HashMap<>();
        map.get(12);
    }
}
class animals{
    public void shout(){
        System.out.println("哈哈哈哈");
    }
}
class birld extends animals{

    @Override
    public void shout() {
        super.shout();
    }
    public void eat(){
        System.out.println("叽叽喳喳");
    }
}
