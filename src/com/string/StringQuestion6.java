package com.string;

import java.util.Scanner;

public class StringQuestion6 {
    //1.计算字符个数
    public static int calculateString(String s,char b){
        int length=s.length();
        int num=0;
        if(s!=null&&s.length()>0){
            for(int i=0;i<length;i++){
                if(b==s.charAt(i)){
                    num++;
                }
            }
        }
        else{
            num=0;
        }
        return num;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String s=scan.next().toLowerCase();
        Character i=scan.next().charAt(0);
        Character.toLowerCase(i);
        System.out.print(calculateString(s,i));
    }
}
