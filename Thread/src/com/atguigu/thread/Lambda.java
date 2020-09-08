package com.atguigu.thread;

public class Lambda {
    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈哈哈");
            }
        }).start();*/
        /*new Thread(()->{
                System.out.println("哈哈哈哈");
        }).start();*/
        Love me=(a)->{
                System.out.println("真开心"+a);
        };
        me.happy(10);
    }
}
interface Love{
    public void happy(int a);
}
class ILove implements Love{
    @Override
    public void happy(int a) {
        System.out.println("真开心");
    }
}