package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //逆波兰表达式，后缀表达式
        String suffixExpression="3 -4 - 5 * 6 -";
        List<String> list = getList(suffixExpression);
        int i1 = caculator(list);
        System.out.println(i1);
        //中缀表达式
        String expression="11+((2+3)*4)-5";
        List<String> list1 = toList(expression);
        //[11, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        System.out.println("中缀表达式："+list1);
        List<String> suffix = toSuffix(list1);
        System.out.println("后缀表达式："+suffix);
        int i = caculator(suffix);
        System.out.println("计算结果："+i);
        /*System.out.println(list);
        int caculator = caculator(list);
        System.out.printf("运算式：%s=%d\n",suffixExpression,caculator);*/
    }
    //将字符串转为list
    public static List<String> toList(String s)  {
        char[] chars = s.toCharArray();//将字符串转为数组
        List<String> list = new ArrayList<>();
        String str="";
        char c=' ';
        for (int i = 0; i <chars.length ; i++) {
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){//不是数字
                list.add(""+c);//将字符转为字符串
            }else {
                str="";
                while(i <chars.length &&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str=str+c;
                    i++;
                }
                i--;
                list.add(str);
            }
        }
        return list;
    }
    //中缀表达式转后缀表达式
    public static List<String> toSuffix(List<String> list){
        Stack<String> s1 = new Stack<>();//符号栈
        ArrayList<String> s2 = new ArrayList<>();//其他元素栈
        for (String item:list) {
            if(item.matches("\\d+")){//是数字
                s2.add(item);
            }else {
                if (item.equals("(")){
                    s1.push(item);
                }else if(item.equals(")")){
                    while(!s1.peek().equals("(")){
                        s2.add(s1.pop());
                    }
                    s1.pop();
                }else {
                    while (s1.size()!=0&&grade(s1.peek())>=grade(item)){//比较优先级
                        s2.add(s1.pop());
                    }
                    s1.push(item);
                }
            }
        }
        //把s1剩下的都放入s2
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    //将字符串转为list
    public static List<String> getList(String expression){
        String[] split=expression.split(" ");//以空格分割形成一个数组
        List<String> list=new ArrayList<>();
        for(String item: split){
            list.add(item);
        }
        return list;
    }
    //利用后缀表达式计算
    public static int caculator(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("[1-9\\d*]|0|-[1-9\\d*]")) {//正则表达式  多位数
                //入栈
                stack.push(item);
            }
            //运算符
            else {
                int item2=Integer.parseInt(stack.pop());
                int item1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=item1+item2;
                }else if(item.equals("-")){
                    res=item1-item2;
                }else if(item.equals("*")){
                    res=item1*item2;
                }else if(item.equals("/")){
                    res=item1/item2;
                }else {
                    throw new RuntimeException("运算符异常");
                }
                stack.push(""+res);
                System.out.println(res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    //判断运算符优先级
    public static int grade(String  a){
        if(a.equals("+")||a.equals("-")){
            return 1;
        }else if(a.equals("*") ||a.equals("/")){
            return 2;
        }else
        {
            return 0;
        }
    }
}
