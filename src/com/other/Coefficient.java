package com.other;

import java.util.Scanner;
//
public class Coefficient {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long data=scanner.nextLong();
        if (data!=1){
            int i=2;
            while(i<=data){
                if(data%i==0){
                    data/=i;
                    System.out.print(i+" ");
                }
                else{
                    i++;
                }
            }
        }
    }
}
