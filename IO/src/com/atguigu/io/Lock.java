package com.atguigu.io;

/**
 * 可重入锁
 */
public class Lock {
    Mylock lock=new Mylock();
    public  void a() throws InterruptedException {
        lock.lock();
        System.out.println("1------------>"+lock.getThreadCount());
        b();
        lock.unLock();
        System.out.println("4------------>"+lock.getThreadCount());
    }
    public void b() throws InterruptedException {
        lock.lock();
        System.out.println("2------------>"+lock.getThreadCount());
        lock.unLock();
        System.out.println("3------------>"+lock.getThreadCount());
    }
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        lock.a();
    }
}
class Mylock{
    private boolean flag=false;
    private int threadCount=0;
    private Thread current=null;

    public int getThreadCount() {
        return threadCount;
    }
    //上锁
    public synchronized void lock() throws InterruptedException {
        Thread t=Thread.currentThread();
        if(flag&&current!=t){
            wait();
        }
        threadCount++;
        flag=true;
        current=t;
    }
    //解锁
    public synchronized void unLock(){
        if(current==Thread.currentThread()){
            threadCount--;
            if(threadCount==0){
                current=null;
                notifyAll();
                flag=false;
            }
        }
    }
}
