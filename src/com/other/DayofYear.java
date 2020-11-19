package com.other;

import java.util.Scanner;
//每年第几天
public class DayofYear {
    public static int dayofyea(String date){
        int[] arr={0,31,28,31,30,31,30,31,31,30,31,30,31};
        String[] split=date.split("-");
        int day=Integer.parseInt(split[2]);
        int month=Integer.parseInt(split[1]);
        int year=Integer.parseInt(split[0]);
        for(int i=0;i<month;i++){
            day+=arr[i];
        }
        if(month>2){
            if(year%400==0||(year%4==0&&year%100!=0)){
                day++;
            }
        }
        return day;
    }
    public static void main(String[] args){
        System.out.println("请输入一个时间");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(dayofyea(s));
    }
}
