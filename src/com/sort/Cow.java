package com.sort;

import java.util.*;

public class Cow {
    public static void main(String[] args) {
        System.out.println("请输入奶牛数量：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入编码下x[]");
        String s = scanner.nextLine();
        String[] array = s.split(" ");
        int[] arraylist = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arraylist[i] = Integer.parseInt(array[i]);
        }
        //List<Integer> arrays=new ArrayList();
        //Arrays.sort(arraylist);
        //Collections.sort(arrays);
        quicksort(arraylist,0,arraylist.length-1);
        long quality=0;
        for(int i=0;i<arraylist.length;i++){
            if(i==0){
                quality=arraylist[i];
            }
            else{
                quality*=((arraylist[i]-i)%1000000007);
                quality%=1000000007;
            }
        }
        System.out.println(quality%1000000007);
    }
        public static void quicksort(int[] s1,int low,int high){
            if(low<high){
                int index =getIndex(s1,low,high);
                quicksort(s1,0,index-1);
                quicksort(s1,index+1,high);
            }
        }
        public static int getIndex(int[] arr,int low,int high){
            int temp=arr[low];
            while(low<high){
                //队尾元素大于基准数据的时候，向前移动high指针
                while(low<high&&temp<=arr[high]){
                    high--;
                }
                //此时high指针下的数据已经小于基准数据，赋值给low指针下的数据
                arr[low]=arr[high];
                while(low<high&&temp>=arr[low]){
                    low++;
                }
                arr[high]=arr[low];
            }
            arr[low]=temp;
            return low;
        }
}
