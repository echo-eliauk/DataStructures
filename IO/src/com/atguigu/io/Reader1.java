package com.atguigu.io;


import java.io.*;

public class Reader1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("IO/lib/a.txt");
        BufferedReader stream=null;
        int temp;
        try {
            stream=new BufferedReader(new FileReader(file));
            /*char[] a=new char[4];
            while((temp=stream.read(a))!=-1){
                String s =new String(a,0,temp);
                System.out.println(s);
            }*/
            //加入字符缓冲流
            String str;
            while((str=stream.readLine())!=null){
                System.out.println(str);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream!=null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
