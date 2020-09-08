package com.atguigu.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期（格式：2010-5-11）：");
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        Calendar c=new GregorianCalendar();
        c.setTime(date);
        int day=c.get(Calendar.DAY_OF_MONTH);
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        c.set(Calendar.DAY_OF_MONTH,1);
        for (int i = 0; i <c.get(Calendar.DAY_OF_WEEK)-1; i++) {
            System.out.print("\t");
        }
        int max=c.getActualMaximum(Calendar.DATE);
        for (int i = 0; i < max ; i++) {
            if(c.get(Calendar.DAY_OF_MONTH)==day){
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
            }else{
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
            }
            if(c.get(Calendar.DAY_OF_WEEK)==7){
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
