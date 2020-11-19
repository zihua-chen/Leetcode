package com.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    public  static List<Integer> getfactor(int k){
        List<Integer> list=new ArrayList<>();
        int num=2;
        while(num>=k){
            if(k%num==0){
                list.add(num);
            }
            else{
                num++;
            }
        }
        list.add(k);
        return list;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int k=s.nextInt();
        List<Integer> list=new ArrayList<>();
        list=getfactor(k);
        //if(){}
    }
}
