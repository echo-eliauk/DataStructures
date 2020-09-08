package com.atguigu.queue;

import java.util.Queue;
import java.util.Scanner;

public class QueueArrayDemo {
    public static void main(String[] args) {

        QueueArray queue = new QueueArray(3);
        char key=' ';//接收用户输入
        Scanner scanner=new Scanner(System.in);//用户输入
        boolean loop=true;
        //菜单
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列取出数据");
            System.out.println("h:显示队列头信息");
            System.out.println("e:退出队列");
            System.out.println("请输入字符：");
            key=scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res=queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res=queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
class QueueArray{
    private int maxSize;//数组容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr; //数组模拟队列
    //创建队列的构造器
    public QueueArray(int arrSize){
        maxSize=arrSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //退数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }
    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列头信息
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front+1];
    }
}