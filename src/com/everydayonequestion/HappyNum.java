package com.everydayonequestion;
//leetcod.202 编写一个算法来判断一个数是不是快乐数。快乐数定义：对于一个正整数，每一次将该数替换为它每个位置上的数的平方和，
// 然后重复这个过程知道变为1.如果是无限循环，则就不是快乐数。
//解题思路：对于一个数的每个位置数平方和，在数学证明上，可以证明如果是无限循环，则是出现了环链。所以找环成了关键。
//建议快慢指针法
public class HappyNum {
    public static boolean isHappy(int n){
        int low=n;
        int fast=doSum(n);
        while(low!=fast){
            low=doSum(low);
            fast=doSum(doSum(fast));

        }
        return low==1;
    }
    public static int doSum(int n){
        int sum=0;
        while(n!=0){
            int digit=n%10;
            sum+=(digit)*(digit);
            n=n/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.print(isHappy(19));
    }
}
