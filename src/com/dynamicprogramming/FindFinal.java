package com.dynamicprogramming;//严格意义上说此题并没用到动态规划
//给定一个正整数数组，最大为100个成员，从第一个成员开始，走到数组最后一个成员最少的步骤数，
//第一步必须从第一元素开始，1<=步长<len/2, 第二步开始以所在成员的数字走相应的步数，如果目标不可达返回-1，只输出最少的步骤数量

import java.util.*;

public class FindFinal {
    public static int[] getNextStep(int[] array,int length){
        int[] nextstep=new int[length];
        nextstep[0]=0;
        nextstep[length-1]=0;
        for(int i=1;i<length-1;i++){
            nextstep[i]=i+array[i];
        }
        return nextstep;
    }
    //array 代表此数组，nextstep数组代表每一步的下一步下标
    //解题思路为递归法，从后往前走
    public static void solution1(int[] nextstep, int index, int step, TreeSet<Integer> ts){
        if(index>=1&&index<nextstep.length/2){
            step++;
            ts.add(step);
        }
        if(index==0){
            step=0;
            ts.add(step);
        }
        for(int i=1;i<index;i++){//索引从1开始，从小到大搜索，应为第一步只能为
            if(nextstep[i]==index){//从索引的小到
                step++;
                solution1(nextstep,i,step,ts);
            }
        }
        if(ts.isEmpty()){
            ts.add(-1);
        }
    }
    //解题思路：一般性的循环思路,从前往后走
    public static void solution2(int[] nextstep, int index, TreeSet<Integer> ts){
        int i=1;
        while(i<index/2){
            int step=1;
            int stepindex=i;
            while(stepindex<=index){
                if(stepindex==index){
                    ts.add(step);
                    break;
                }
                step++;
                stepindex=nextstep[stepindex];
            }
            i++;
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入一个数组");
        Scanner scanner = new Scanner(System.in);
        String arraystring = "";
        String regex = "^[0-9 ]+$";
        while(!arraystring.matches(regex)){
            arraystring = scanner.nextLine();
        }
        String[] strings=arraystring.split(" ");
        int[] array=new int[100];
        for(int i=0;i<strings.length;i++){
            array[i]=Integer.parseInt(strings[i]);
        }
        int[] nextstep=getNextStep(array,strings.length);
        TreeSet<Integer> ts=new TreeSet();
        //solution1(nextstep,nextstep.length-1,0,ts);
        solution2(nextstep,nextstep.length-1,ts);
        Iterator it = ts.iterator();
        System.out.print(it.next());
    }
}
