package com.atguigu.thread;

public class StartThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i <10 ; i++) {
            System.out.println("11111---");
        }
    }

    public static void main(String[] args) {
        StartThread st=new StartThread();
        st.start();
        for (int i = 0; i <20 ; i++) {
            System.out.println("sun---");
        }
    }
}
