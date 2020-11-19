package com.practic;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Test {
    public static String trainsform(String date){
        String[] split=date.split(" ");
        int day=Integer.parseInt(split[3]);
        int week=Integer.parseInt(split[2]);
        int month=Integer.parseInt(split[1]);
        int year=Integer.parseInt(split[0]);
        day=week*7+day;
        String s="";
        if(month<10){
            String monthstring="0"+day;
            s=year+"-"+monthstring;
        }
        else{
            String monthstring=""+day;
            s=year+"-"+monthstring;
        }
        if(day<10){
            String daystring="0"+day;
            s+="-"+daystring;
        }
        else{
            String daystring=""+day;
            s+="-"+daystring;
        }
        return s;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String date=scanner.nextLine();
        System.out.print(trainsform(date));

    }
}
