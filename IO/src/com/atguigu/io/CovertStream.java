package com.atguigu.io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取百度源码
 */
public class CovertStream {
    public static void main(String[] args) {
        BufferedReader is=null;
        BufferedWriter os=null;
        try{
            is=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));
            os=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("IO/lib/baidu.html")));
            String temp;
            //byte[] c=new byte[1024];
            while((temp=is.readLine())!=null){
                System.out.print(temp);
                os.write(temp);
                os.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void test1(){

        InputStreamReader is=null;
        try{
            is=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");
            int temp;
            //byte[] c=new byte[1024];
            while((temp=is.read())!=-1){
                System.out.print((char)temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void test2(){

        InputStream is=null;
        try{
            is=new URL("http://www.baidu.com").openStream();
            int temp;
            //byte[] c=new byte[1024];
            while((temp=is.read())!=-1){
                System.out.print((char)temp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
