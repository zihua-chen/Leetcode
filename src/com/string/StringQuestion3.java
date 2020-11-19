package com.string;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

//有俩个字符串A和B，其中A串是一个01串，B串中除了    0和1还有可能有“？”。考虑有多少种可能的字符B可以在A中完成匹配
//解题思路一，利用回溯法，先将问号填充，得出B串的所有可能字符串，然后进行判断.未能在规定时间内通过。可知暴力匹配之外还有更好的办法
public class StringQuestion3 {
    public static int sortValueOf1(String A,String B){
        int num = 0;
        char[] chars=new char[2];
        chars[0]='0';
        chars[1]='1';
        TreeSet<String> ts = new TreeSet();
        sortPadding(chars,0,B.length(),B.toCharArray(),ts);
        Iterator it=ts.iterator();
        while(it.hasNext()){
            String s=it.next().toString();
            if(A.indexOf(s)==-1){
                continue;
            }
            num++;
        }
        return num;
    }
    //A是检验字符串，chars是长度为2的01字符数组，vacant为B
    public static void sortPadding(char[] chars,int k ,int end,char[] vacant,TreeSet<String> ts){
        if(k==end){
            ts.add(String.valueOf(vacant));
            return;
        }
        for(int i=0;i<2;i++){
            if(vacant[k]=='?'){
                vacant[k]=chars[i];
                sortPadding(chars,k+1,end,vacant,ts);
                vacant[k]='?';
            }
            else{
                sortPadding(chars,k+1,end,vacant,ts);
            }
        }
    }
    //解法二：改写字符匹配算法(暴力匹配也行：暴力匹配使用2个for循环，这里使用KMP算法)，将“？”视为万能字符
    public static int sortValueOf2(String s1,String s2){//s2为匹配字符串,此方法为暴力匹配
        TreeSet<String> ts = new TreeSet();
        char[] chars1=s1.toCharArray();
        char[] chars2=s2.toCharArray();
        for(int i=0;i<s1.length()-s2.length()+1;i++){
            if(chars1[i]==chars2[0]||chars2[0]=='?'){
                int point=0;
                for(int j=0;j<s2.length();j++){
                    if(chars1[i+j]==chars2[j]||chars2[j]=='?'){
                        point++;
                    }
                    else{
                        break;
                    }
                    if(point==s2.length()){
                        ts.add(s1.substring(i,i+s2.length()));
                    }
               }
           }
        }
        return ts.size();
    }
    //下列代码是KMP算法的写法
    public static int KMP(String s1,String s2){
        int[] next = new int[s2.length()];
        next = getNext(s2);
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        int i=0;
        int j=0;
        while(i<s1.length()&&j<s2.length()){
            if(j==-1||a[i]==b[j]||b[j]=='?'){
                i++;
                j++;
            }
            else{
                j=next[j];
            }
        }
        if(j==s2.length()){
            return i-j;
        }
        else{
            return -1;
        }
    }
    public static int[] getNext(String s){
        char[] chars=s.toCharArray();
        int[] next=new int[s.length()];
        int j=0;
        int k=-1;//K即代表了当前j指针前的字符串的回退指针，（也就是说K-1为最大相等长度）
        while(j<s.length()-1){
            if(k==-1||chars[j]==chars[k]){//如果当前下标与K指针下的数值相等即加一
                next[++j]=++k;
            }
            else{//如果不相等，则回退指针减小，之所以为next[k]，是因为next[k]-1是除了k-1外的最大相等长度，不明白可自行画图证明
                k=next[k];
            }
        }
        return next;
    }
    //解法三：使用正则表达式
    public static int sortByregex(String A,String B){
        B=B.replaceAll("\\?",".");
        TreeSet<String> res=new TreeSet();
        for(int i=0;i<A.length()-B.length()+1;i++){
            String s = A.substring(i,i+B.length());
            if(s.matches(B)){
                res.add(s);
            }
        }
        return res.size();
    }
    public static void main(String[] args) {
            Scanner output=new Scanner(System.in);
            String A=output.next();
            String B=output.next();
            System.out.print(sortByregex(A,B));
    }
}
