package com.atguigu.io;


import java.io.*;

public class Writer1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("IO/lib/t.txt");
        BufferedWriter stream=null;
        int temp;
        try {
            stream=new BufferedWriter(new FileWriter(file));
            /*String a="大家好，这里是中国\n";
            char[] chars = a.toCharArray();
            stream.write(chars);
            stream.append("itis easy").append("hello");*/
            stream.append("大家好");
            stream.newLine();
            stream.flush();


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
