package com.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartyNum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入到达时间已经离开时间，（1,1）表示结束输入");
        String input= "";
        List<String> peoplemasage=new ArrayList();
        while(!input.equals("-1,-1")){
            if(input!=null&&input.length()!=0){
                peoplemasage.add(input);
            }
            input=scanner.nextLine();
            input=input.trim();
        }
        int[] maxpeople=new int[8];
        for(String s:peoplemasage){
            String[] split=s.split(",");
            int star=Integer.parseInt(split[0]);
            int end=Integer.parseInt(split[1]);
            for(int i=star-12;i<end-12;i++){
                maxpeople[i]++;
            }
        }
        for(int i=0;i<8;i++){
            int star=i+12;
            int end=i+13;
            System.out.println("["+star+","+end+"):"+maxpeople[i]);
        }
    }
}
