package com.atguigu.io;

/**
 * 单例模式:只有一个对象
 */
public class DoubleChecking {
    //静态属性
    private static volatile DoubleChecking instance;
    //构造器私有化
    private DoubleChecking(){

    }
    //静态方法
    public static DoubleChecking getInstance(long time){
        synchronized (DoubleChecking.class)
        {
            if(instance==null){
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance=new DoubleChecking();
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            System.out.println(DoubleChecking.getInstance(1000));
        });
        t.start();
        System.out.println(DoubleChecking.getInstance(500));
    }
}
