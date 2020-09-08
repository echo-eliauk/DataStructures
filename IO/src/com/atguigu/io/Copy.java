package com.atguigu.io;

import java.io.*;

public class Copy {
    public static void main(String[] args) {
        String source="IO/lib/yashaung.jpg";
        String output="IO/lib/a.jpg";
        copy1(source,output);
    }
    public static void copy1(String source,String output){

        InputStream in=null;
        OutputStream stream=null;
        try {
            //加入缓冲流提升性能
            in=new BufferedInputStream(new FileInputStream(source));
            stream =new BufferedOutputStream(new FileOutputStream(output,true));
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
