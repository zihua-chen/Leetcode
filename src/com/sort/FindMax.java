package com.sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] data = new int[str.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(str[i]);
        }
        System.out.print(findKthNum1(data,3));
    }
    public static int findKthNum1(int[] data, int k) {//
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int item : data) {
            if (heap.size() < k) {
                heap.add(item);
            } else if (item > heap.peek()) {
                heap.poll();
                heap.add(item);
            }
        }
        return heap.poll();
    }
}
