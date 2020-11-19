package com.other;

import java.util.Scanner;
//跳跃问题，给你一个非负数整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度，判断你能否到达最后一个点
public class JumpGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().replace("[", "").replace("]", "").split(",");
        int[] data = new int[str.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(str[i]);
        }
        int[] nextstep=getMaxStep(data,str.length);
        System.out.print(accessible(nextstep,nextstep.length-1));
    }
    public static int[] getMaxStep(int[] array,int length){
        int[] nextstep=new int[length];
        nextstep[length-1]=0;
        for(int i=0;i<length-1;i++){
            nextstep[i]=i+array[i];
        }
        return nextstep;
    }
    public static boolean accessible(int[] array,int index){
        if(index<=array[0]){
            return true;
        }
        for(int i=index-1;i>0;i--){
            if(array[i]>=index){
                boolean a=accessible(array,i);
                if(a){
                    return true;
                }
                else{
                    continue;
                }
            }
        }
        return false;
    }
    //贪心算法
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
