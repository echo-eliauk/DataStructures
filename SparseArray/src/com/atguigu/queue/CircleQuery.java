package com.atguigu.queue;

import java.util.Scanner;

public class CircleQuery {
    public static void main(String[] args) {

        Circle queue = new Circle(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);//用户输入
        boolean loop = true;
        //菜单
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列取出数据");
            System.out.println("h:显示队列头信息");
            System.out.println("e:退出队列");
            System.out.println("请输入字符：");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
class Circle{
    private int maxSize;//数组容量
    private int front;//队列第一个元素
    private int rear;//队列最后一个元素的后一个位置
    private int[] arr; //数组模拟队列
    //初始化队列
    public Circle(int size){
        maxSize=size;
        arr=new int[maxSize];
        front=0;
        rear=0;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    public void addQueue(int data){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear]=data;
        rear=(rear+1)%maxSize;
    }
    public int getQueue(){
        if(isEmpty())
        {
            throw new RuntimeException("队列为空");
        }
        int data=arr[front];
        front=(front+1)%maxSize;
        return data;
    }
    //显示队列所有数据
    public void showQueue(){
        //1.遍历
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        return arr[front];
    }

}
