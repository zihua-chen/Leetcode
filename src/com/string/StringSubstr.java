package com.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringSubstr {
    public static void main(String[] args) throws IOException {
        //Scanner scanner=new Scanner(System.in);
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder outputString= new StringBuilder();
        while((input=bf.readLine())!=null){
            int num=Integer.parseInt(input);
            for(int i=0;i<num;i++){
                String s=bf.readLine();
                while(s.length()%8!=0){
                    s+="0";
                }
                while(s.length()!=0){
                    //outputString.append(s.substring(0,8)+"\n");
                    System.out.println(s.substring(0,8));
                    s=s.substring(8);
                }
            }
        }
        bf.close();
        //System.out.print(outputString);
    }
}
