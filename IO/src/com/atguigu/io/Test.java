package com.atguigu.io;

import java.io.*;

/**
 * 图片读取到字节数组
 * 字节数组读取到文件
 */
public class Test {
    public static void main(String[] args) {
        byte[] bytes = fileToArray("IO/lib/yashaung.jpg");
        arrayToFile(bytes,"IO/lib/b.jpg");
    }

    /**
     * 图片到字节数组
     * 图片到程序：fileInputStream
     * 程序到字节数组：ByteArrayOutputStream
     * @param src
     */
    public static byte[] fileToArray(String src){
        FileInputStream in =null;
        ByteArrayOutputStream baos;
        byte[] b1 = new byte[0];
        try {
            in=new FileInputStream(src);
            baos=new ByteArrayOutputStream();
            byte[] b=new byte[1024];
            int temp;
            while((temp=in.read(b))!=-1){
                baos.write(b,0,temp);
            }
            b1=baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b1;
    }

    /**
     * 字节数组到文件
     * 字节数组到程序：ByteArrayInputStream
     * 程序到文件：FileOutputStream
     * @param src
     * @param des
     */
    public static void arrayToFile(byte[] src,String des){
        OutputStream os=null;
        try {
            InputStream is = new ByteArrayInputStream(src);
            os=new FileOutputStream(des);
            byte[] b=new byte[1024];
            int temp;
            while((temp=is.read(b))!=-1){
                os.write(b,0,temp);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(os!=null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
