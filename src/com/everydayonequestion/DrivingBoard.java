package com.everydayonequestion;

import java.util.Iterator;
import java.util.TreeSet;

/*你正在使用一堆木块建造的跳水板。有俩种类型的木板，其中长度较短的木板长度为shorter,其中长度较长的木板
叫做longer。你必须正好使用K块木板。编写一个方法，生成一个跳水板所有可能的长度*/
public class DrivingBoard {
    public void solution1(int shorter,int longer,int k){
        TreeSet<Integer> treeSet=new TreeSet<>();
        if(k==0){
            System.out.println();
        }
        else if(shorter==longer){
            System.out.println(shorter*k);
        }
        else {
            for(int i=0;i<=k;i++){
                int length=i*(shorter)+(k-i)*(longer);
                treeSet.add(length);
            }
            String output="{";
            Iterator iterator=treeSet.iterator();
            while (iterator.hasNext()){
                String s=iterator.next().toString();
                output+=s+" ";
            }
            output=output.trim();
            System.out.println(output);
            output=output.replaceAll(" ",",");
            output+="}";
            System.out.println(output);
        }
    }
    public int[] solution2(int shorter,int longer,int k){
        if(k==0){
            return new int[]{};
        }
        else if(shorter==longer){
            return new int[]{shorter*k};
        }
        else {
            int[] res=new int[k+1];
            for (int i = 0; i <= k; i++) {
                int length = i * (shorter) + (k - i) * (longer);
                res[i]=length;
            }
            return res;
        }
    }
}
