package com.other;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    /**
     *
     * @param x int整型 x升容积的油桶
     * @param y int整型 y升容积的油桶
     * @param z int整型 需要恰好得到的石油
     * @return bool布尔型
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        // write code here
        if(x==0&&y==0){
            return false;
        }
        if(x==0){
            return z % y == 0;
        }
        if(y==0){
            return z % x == 0;
        }
        int gcd=getGcd(x,y);
        return z % gcd == 0;
    }
    public static int getGcd(int num1,int num2){
        int min=num1>num2?num2:num1;
        int gcd=1;
        for(int i=2;i<=min;i++){
            if(num1%i==0&&num2%i==0){
                gcd=i;
            }
        }
        return gcd;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=bf.readLine())!=null){
            String[] strings=input.split(",");
            int x=Integer.parseInt(strings[0]);
            int y=Integer.parseInt(strings[1]);
            int z=Integer.parseInt(strings[2]);
            System.out.print(canMeasureWater(x,y,z));
        }
        bf.close();
    }
}
