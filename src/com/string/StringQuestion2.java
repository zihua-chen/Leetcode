package com.string;
import  java.util.*;
//输入一个字符串，按字典序打印出该字符串中字符的所有排列。
public class StringQuestion2 {
    //解题思路1:回溯填充法+用set进行去重
    public static void sortString1(String s){
        char[] chars = s.toCharArray();
        TreeSet<String> ts = new TreeSet();
        backtrack1(chars,0,chars.length,new char[chars.length],new boolean[chars.length],ts);
        Iterator it = ts.iterator();
        StringBuilder output = new StringBuilder();
        output.append("[");
        while(it.hasNext()){
            output.append(it.next()).append(", ");
        }
        System.out.print(output.substring(0, output.length()-2)+"]");

    }
    public static void backtrack1(char[] chars,int k,int end,char[] temp,boolean[] hash,TreeSet<String> ts){
        if(k==end){
            ts.add(String.valueOf(temp));
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(!hash[i]){
                temp[k]=chars[i];
                hash[i]=true;
                backtrack1(chars,k+1,end,temp,hash,ts);
                hash[i]=false;
            }
        }
    }
    //解题思路2：依然使用回溯法，但是回溯法使用交换方式实现，另外使用剪枝法进行去重，但是此方法未排序，通用做法还是放入TreeSet进行排序
    public static void sortString2(String s){
        char[] chars = s.toCharArray();
        StringBuilder output = new StringBuilder();
        output.append("[");
        backtrack2(chars,0,chars.length,output);
        System.out.print(output.substring(0, output.length()-2)+"]");
    }
    public static boolean accessSwap(char[] chars,int begin,int end){
        for(int i=begin;i<end;i++){
            if(chars[i]==chars[end]){
                return false;
            }
        }
        return true;
    }
    public static void swap(char[] chars,int k ,int i){
        char temp=chars[k];
        chars[k]=chars[i];
        chars[i]=temp;
    }
    public static void backtrack2(char[] chars,int k,int end,StringBuilder output){
        if(k==end){
            output.append(String.valueOf(chars)).append(", ");
        }
        for(int i=k;i<end;i++){
            if(!accessSwap(chars,k,i)){
                continue;
            }
            swap(chars,k,i);
            backtrack2(chars,k+1,end,output);
            swap(chars,k,i);
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s=scan.next();
        sortString2(s);
    }
}
