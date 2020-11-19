package com.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

//输入一个字符，输出该字符中相邻字符的所有组合
//解题思路：暴力加去重
public class StringQuestion4 {
    public static void main(String[] args) {
        HashMap<Integer,TreeSet<String>> tsMap=new HashMap();
        Scanner output = new Scanner(System.in);
        String s = output.next();
        char[] chars=s.toCharArray();
        for(int length=1;length<=s.length();length++){//i表示字符的长度
            if(length==1){
                TreeSet<String> ts= new TreeSet();
                for(int i=0;i<s.length();i++){
                    ts.add(String.valueOf(chars[i]));
                }
                tsMap.put(length,ts);
            }
            else{
                TreeSet<String> ts= new TreeSet();
                for(int index=0;index<=s.length()-length;index++){
                    ts.add(s.substring(index,index+length));
                }
                tsMap.put(length,ts);
            }
        }
        StringBuilder outputString=new StringBuilder();
        for(int key=1;key<=s.length();key++){
            TreeSet<String> ts=tsMap.get(key);
            Iterator it=ts.iterator();
            while(it.hasNext()){
                outputString.append(it.next()).append(" ");
            }
        }
        outputString.trimToSize();
        System.out.print(outputString);
    }
}
