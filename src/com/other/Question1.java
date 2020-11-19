package com.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给出一个无序数组，输出和为K得2个数
public class Question1 {
    public static List<String> getRes(int[] array,int k){
        selectSort(array);
        List<String> list=new ArrayList<String>();
        int low=0;
        int high=array.length-1;
        while(low<high){
            if(array[low]+array[high]==k){
                list.add("\""+array[low]+","+array[high]+"\"");
                low++;
                high--;
            }
            else if(array[low]+array[high]>k){
                high--;
            }
            else {
                low++;
            }
        }
        return list;
    }
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args){

    }
}
