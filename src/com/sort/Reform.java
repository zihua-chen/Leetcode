package com.sort;

import java.awt.*;
import java.util.Scanner;

public class Reform {// 洗牌函数
    public static int[] doReform(int[] a){
        int n=a.length/2;
        int[] b=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(i<n){
                b[2*i]=a[i];
            }
            else{
                b[2*(i-n)+1]=a[i];
            }
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        String arraystring = "";
        String regex = "^[0-9 ]+$";
        while(!arraystring.matches(regex)){
            arraystring = scanner.nextLine();
        }
        String[] strings=arraystring.split(" ");
        int[] array=new int[2*n];
        for(int i=0;i<strings.length;i++){
            array[i]=Integer.parseInt(strings[i]);
        }
        for(int i=0;i<k;i++){
            array=doReform(array);
        }
        StringBuilder output=new StringBuilder();
        for(int s:array){
            output.append(s+" ");
        }
        output.trimToSize();
        System.out.print(output);
    }
}
