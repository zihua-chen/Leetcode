package com.practic;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str=new String[3];
        str = sc.nextLine().replace("A={","").replace("B={","").replace("R=","").split("},");
        String[] astring =str[0].split(",");
        String[] bstring=str[1].split(",");
        String[] Rstring=str[2].split(",");
        int[] Ai=new int[astring.length];
        for(int i=0;i<astring.length;i++){
            Ai[i]=Integer.parseInt(astring[i]);
        }
        Arrays.sort(Ai);
        int[] Bi=new int[bstring.length];
        for(int i=0;i<bstring.length;i++){
            Bi[i]=Integer.parseInt(bstring[i]);
        }
        Arrays.sort(Bi);
        int R=Integer.parseInt(Rstring[0]);
        System.out.print(findAcessible(Ai,Bi,R));
    }
    public static StringBuilder findAcessible(int[] Ai,int[] Bi,int R){
        StringBuilder output=new StringBuilder();
        for(int i=0;i<Ai.length;i++){
            for(int j=0;j<Bi.length;j++){
                if(Ai[i]<=Bi[j]&&(Bi[j]-Ai[i])<=R){
                    output.append("("+Ai[i]+","+Bi[j]+")");
                }
            }
        }
        return output;
    }
    public static StringBuilder findAcessible2(int[] Ai,int[] Bi,int R){
        StringBuilder output=new StringBuilder();
        for(int i=0;i<Ai.length;i++){
            for(int j=Bi.length-1;j<Bi.length;j--){
                if(Bi[j]<Ai[i]){
                    break;
                }
                if(Ai[i]<=Bi[j]&&(Bi[j]-Ai[i])<=R){
                    output.append("("+Ai[i]+","+Bi[j]+")");
                }
            }
        }
        return output;
    }
}
