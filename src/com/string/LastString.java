package com.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        int i=s.length()-2;
        int length=1;
        while(length<s.length()&&s.charAt(i)!=' '){
            length++;
            i--;
        }
        System.out.print(length);
    }
}
