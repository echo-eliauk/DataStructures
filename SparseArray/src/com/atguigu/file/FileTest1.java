package com.atguigu.file;

import java.io.File;
import java.util.*;

public class FileTest1 {
    public static void main(String[] args) {
        File file=new File("D:\\c");
        ArrayList<String> strings = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        HashSet<String> strings1 = new HashSet<String>();
        TreeMap<Integer, String> integerStringTreeMap = new TreeMap<>();
        map.put(1,"张三");
        //printFile(file,0);
    }
    static void printFile(File file,int level){
        for (int i = 0; i <level ; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File temp:files) {
                printFile(temp,level+1);
            }
        }
    }
}
