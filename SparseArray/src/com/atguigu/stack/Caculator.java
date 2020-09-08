package com.atguigu.stack;

public class Caculator {
    public static void main(String[] args) {
        String expression="1111+20*3";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 opeaStack = new ArrayStack2(10);
        int index=0;//用于扫描
        char a=' ';
        int num1=0;
        int num2=0;
        int opea=0;
        int res=0;
        String KeepNum="";
        while (true){
            a=expression.substring(index,index+1).charAt(0);
            if(opeaStack.isOper(a)){//是运算符
                //栈不为空
                if(!opeaStack.isEmpty()){
                    //如果优先级小于上次入栈的运算符
                    //将上次入栈的字符pop出来与前面入栈的数字进行运算，并将结果存入数字栈，且将运算符存入运算符栈
                    if(opeaStack.grade(a)<=opeaStack.grade(opeaStack.peak())){
                        opea=opeaStack.pop();
                        num1=numStack.pop();
                        num2=numStack.pop();
                        res=numStack.caculator(num1,num2,opea);
                        numStack.push(res);
                        opeaStack.push(a);
                    }
                    else{//优先级更高，直接入栈
                        opeaStack.push(a);
                    }
                }else{
                    //栈为空，直接入栈
                    opeaStack.push(a);
                }
            }else{
                //是数字,可能是多位数字
                KeepNum+=a;
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(KeepNum));
                    break;
                }
                else {
                    //如果下一个是字符串
                    if(numStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(KeepNum));
                        //numStack.push(a-48);//a为字符串比数字ASIma多48
                        //将keepNum置空
                        KeepNum="";
                    }
                }
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        //都入栈之后
        //相应出栈计算
        while(true){
            opea=opeaStack.pop();
            num1=numStack.pop();
            num2=numStack.pop();
            res=numStack.caculator(num1,num2,opea);
            numStack.push(res);
            if(opeaStack.isEmpty()){
                break;
            }
        }
        System.out.printf("运算式：%s=%d\n",expression,numStack.pop());
    }
}

class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top=-1;//模拟栈底

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    //获取栈顶元素
    public int peak(){
        return stack[top];
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
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，不能出栈");
        }
        return stack[top--];
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
    //判断是否运算符
    public boolean isOper(char a){
        return a=='+'||a=='-'||a=='*'||a=='/';
    }
    //判断优先级
    public int grade(int a){
        if(a=='+'||a=='-'){
            return 1;
        }else
        {
            return 2;
        }
    }
    //计算
    public int caculator(int num1,int num2,int opea){
        if(opea=='+'){
            return num1+num2;
        }
        else if(opea=='-'){
            return num2-num1;
        }
        else if(opea=='*'){
            return num1*num2;
        }
        else {
            return num2/num1;
        }
    }
}

