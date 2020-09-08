package com.atguigu.io;

public class Web12306 {
    public static void main(String[] args) {
        Web123 w = new Web123(2, "张三");
        Passenger p1 = new Passenger(w, "李四", 2);
        p1.start();
        Passenger p2 = new Passenger(w, "四",1);
        p2.start();
    }
}
class Passenger extends Thread{
    int seats;
    public Passenger(Runnable target,String name,int seats){
        super(target,name);
        this.seats=seats;
    }
}
class Web123 implements Runnable{
    int available;//可用位置
    String name;

    public Web123(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p=(Passenger) Thread.currentThread();
        boolean flag=this.tickets(p.seats);
        if(flag){
            System.out.println("剩余票数："+available);
            System.out.println(p.getName()+"---->"+"出票成功:"+p.seats);
        }else{
            System.out.println(p.getName()+"---->"+"出票失败");
        }
    }
    public  synchronized boolean tickets(int seats){
        if(available>=seats){
            available=available-seats;
            return true;
        }else{
            return false;
        }
    }
}
