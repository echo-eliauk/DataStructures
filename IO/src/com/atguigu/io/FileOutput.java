package com.atguigu.io;

import java.io.*;

public class FileOutput {
    public static void main(String[] args) {
        InputStream in=null;
        OutputStream stream=null;
        try {
            in=new FileInputStream("IO/lib/yashaung.jpg");
           stream = new FileOutputStream("IO/lib/xiong.jpg",true);
           /*String s="I am a handsome boy\n";
            byte[] array = s.getBytes();
            stream.write(array,0,array.length);*/
            byte[] bytes = new byte[1024];
            int temp;
           while((temp=in.read(bytes))!=-1){
               stream.write(bytes,0,temp);
           }
            stream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(stream!=null){
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
