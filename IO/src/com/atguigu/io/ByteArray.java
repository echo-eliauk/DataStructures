package com.atguigu.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArray {
    public static void main(String[] args) {
        byte[] src;
        ByteArrayOutputStream baos=null;
        baos = new ByteArrayOutputStream();
        String s="show me the code";
        byte[] array = s.getBytes();
        baos.write(array,0,array.length);
        src=baos.toByteArray();
        System.out.println(new String(src));
        byte[] src1="show me the code no bb".getBytes();
        InputStream is=new ByteArrayInputStream(src1);
        byte[] b=new byte[5];
        int temp;
        try{
            while((temp=is.read(b))!=-1){
                String s1=new String(b,0,temp);
                System.out.println(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
