package com.everydayonequestion;
//寻找一个数组中是否存在相同的元素
public class FindSame {
    public static int findDuplicate(int[] nums){
        int length=nums.length;
        int i=0;
        int j=1;
        while(nums[i]!=nums[j]){
            i=(i+1)%length;
            j=(j+2)%length;
            if(i==j){
                j=(i+1)%length;
            }
        }
        return nums[i];
    }
    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.print(findDuplicate(nums));
    }
}
