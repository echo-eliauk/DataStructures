package com.atguigu.io;

import java.io.*;

public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("IO/lib/a.txt");
        InputStream stream=null;
        FileOutputStream stream1 = new FileOutputStream("IO/lib/b.txt");
        int temp;
        try {
            stream= new FileInputStream(file);
            while((temp=stream.read())!=-1){
                stream1.write(temp);
                System.out.println((char)temp);
            }
            stream1.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream!=null){
                try {
                    stream1.close();
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
