package com.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class RandomNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=bf.readLine())!=null){
            int num=Integer.parseInt(input);
            Set<Integer> newset=new TreeSet();
            for(int i=0;i<num;i++){
                int number=Integer.parseInt(bf.readLine());
                newset.add(number);
            }
            for(Integer i:newset){
                System.out.println(i);
            }
        }
        bf.close();
    }
}
