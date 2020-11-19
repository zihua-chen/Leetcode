package com.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaxString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=bf.readLine())!=null){
            List<String> strings=new ArrayList<String>();
            char[] st=s.toCharArray();
            String curstring="";
            for(int i=0;i<st.length;i++){
                if(st[i]>='0'&&st[i]<='9'){
                    curstring+=String.valueOf(st[i]);
                }
                else{
                    if(curstring!=null&&curstring.length()>0){
                        strings.add(curstring);
                        curstring="";
                    }
                }
            }
            if(curstring!=null&&curstring.length()>0){
                strings.add(curstring);
            }
            int max = 0;
            for (int i=0; i<= strings.size()-1;i++){
                if (strings.get(i).length() >= max)max = strings.get(i).length();
            }
            for (int i=0; i<= strings.size()-1;i++){
                if (strings.get(i).length() == max)
                    System.out.print(strings.get(i));
            }
            System.out.println(","+max);
        }
        bf.close();
    }
}
