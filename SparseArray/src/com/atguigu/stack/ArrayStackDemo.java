package com.atguigu.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.list();
    }
}
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top=-1;//模拟栈底

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    //入栈
    public void push(int data){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top]=data;
    }
    //出栈
    public void pop(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        System.out.printf("出栈元素为：%d\n",stack[top--]);
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        while (top!=-1){
            System.out.printf("元素为：%d\n",stack[top--]);
        }
    }
}
