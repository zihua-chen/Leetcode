package com.string;
import java.lang.reflect.Array;
import  java.util.*;

public class StringQuestion1 {
    //1.循环移位包含，给定S1和S2，要求判定S2是否能被S1做循环移位得到的字符串包含。
    //解题思路：进行循环移位的结果是S1S1的子字符串，只要判断S2是否是S1S1的子字符串即可
    public static Boolean cyclicShiftContains(String s1, String s2){
        String s3 = s1+s1;
        return s3.indexOf(s2) != -1;
    }
    //2.字符串循环移位
    //解题思路一：若循环移位字符串s1,K位,则取S1S1的第s1.length-k到2*(s1.length)-k位
    //解题思路二：将0到s1.length-K和s1.length-k到s1.length,分别进行翻转，然后合并后进行整体翻转
    public static String cyclicShift1(String s1,int k){
        String s2 = s1 + s1;
        return s2.substring(s1.length()-k,2*s1.length()-k);
    }
    public static String cyclicShift2(String s1,int k){
        String s2 = s1.substring(0,s1.length()-k);
        String s3 = s1.substring(s1.length()-k);
        String s4 = new StringBuilder(s2).reverse().toString()+ new StringBuilder(s3).reverse().toString();
        return new StringBuilder(s4).reverse().toString();
    }
    //3.字符串中的单词翻转
    //先将每个单词翻转，然后再将整个字符串翻转
    public static String wordReverse(String s1){
        String[] sumstring = s1.split(" ");
        String s2 = "";
        for(String s:sumstring){
             s2+=new StringBuilder(s).reverse().toString()+" "; 
        }
        //去掉左右空格
        s2 = s2.trim();
        return new StringBuilder(s2).reverse().toString();
    }
    //4.俩个字符串包含的字符是否完全相同
    //解题思路：可以是用HashMap来映射字符和出现的次数，然后比较俩个字符串的数量是否相同，简单情况如只有字母的情况下
    //也可以使用数组来比较
     public static boolean isSameSimple(String s1,String s2){
          int[] ints = new int[26];//英文字母只有26个
          for(char c :s1.toCharArray()){
              ints[c - 'a']++;
          }
          for(char c :s2.toCharArray()){
              ints[c - 'a']--;
          }
          for(int i:ints){
              if (i!=0){
                  return false;
              }
          }
         return true;
     }
     public static boolean isSameComplex(String s1,String s2){
        HashMap<Character, Integer> maps=new HashMap();
        //将每个字符压入Map并且统计数量
        for(char c:s1.toCharArray()){
              if(maps.containsKey(c)){
                  int value = maps.get(c);
                  maps.put(c,value+1);
              }
              else{
                  maps.put(c,1);
              }
        }
        //将另一个字符串的字符压出
        for(char b:s2.toCharArray()){
            if(maps.containsKey(b)){
                int value = maps.get(b);
                maps.put(b,value-1);
            }
            else{
                return false;
            }
        }
        for(Map.Entry<Character, Integer> entry:maps.entrySet()){
                 if(entry.getValue()!=0){
                    return false;
                 }
         }
        return true;
     }
     //5.计算一组字符集合可以组成的回文字符串的最大长度
    public static int longespalindrome(String s){
       int[] ints = new int[256];
       for(char c :s.toCharArray()){
          ints[c]++;
       }
       int palindrome = 0;
       for(int i:ints){
          palindrome +=(i/2)*2;
       }
       if(palindrome<s.length()){
          palindrome++;
       }
       return palindrome;
    }
     //6.字符串同构
    //解题思路：记录一个字符上一次出现的位置，如果一样那么就是同构
    public static boolean isIsomorphic(String s1,String s2){
      int[] preIndexs1 = new int[256];
      int[] preIndexs2 = new int[256];
      for(int i=0;i<s1.length();i++){
          char s1p=s1.charAt(i);
          char s2p=s2.charAt(i);
          if(preIndexs1[s1p]!=preIndexs1[s2p]){
              return false;
          }
          preIndexs1[s1p] = i+1;
          preIndexs2[s2p] = i+1;
      }
      return true;
    }
    //7.回文子字符串个数
    //解题思路：1.枚举法，将所有子字符串进行回文验证，通过则总数加一。（在此不做示例）2.从某一字符串开始尝试去扩展
    public static int countSubstrings(String s){
        int counts=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<s.length();i++){
            count1=extendString(s,i,i);
            count2=extendString(s,i,i+1);
            counts+=count1+count2;
        }
        return counts;
    }
    public static int extendString(String s,int start,int end){
        int counts=0;
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            counts++;
        }
        return counts;
    }
    //8.判断一个整数是否是回文，要求不能使用额外的空间(不能创建其他数据结构)，也不能将整数装换成字符串进行判断
    public static boolean ispalindrome1(int x){//解题思路：1.判断从左起和从右起的数字是否相同；
        if(x==0){
            return true;
        }
        if(x<0||x%10==0){
            return false;
        }
        int leftstart=x;
        int rightstart=0;
        while(leftstart%10!=0){
            rightstart=rightstart*10+leftstart%10;
            leftstart/=10;
        }
        return x==rightstart;
    }
    public static boolean ispalindrome2(int x){//解题思路：将整数分成左右俩个部分，右边的部分进行转置再比较
        if(x==0){
            return true;
        }
        if(x<0||x%10==0){
            return false;
        }
        int right=0;
        while(x>right){
            right=right*10+x%10;
            x/=10;
        }
        return x==right||x==right/10;
    }
    //9.统计二进制字符串中连续1和连续0数量相同的子字符串个数.(这到题的中文描述有些问题)
    //英文描述更为直观些：Give a string s ,count number of non-empty(contiguous) substring that have the
    //sme number of 0 and 1,and all the 0 and 1 in these substring are group consecutively.
    public static int countBinarySubstring(String s){
        int cur=1,pre=0,res=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){//统计当前数字相同位数
                cur++;
            }
            else{//出现不同，将当前的不同位数置为前
                pre=cur;
                cur=1;
            }
            if(cur<=pre){//符合要求即加一
                res++;
            }
        }
        return res;
    }
    //给定一个字符串数组strs，请找到一个拼接顺序，使得所有的字符串拼接起来组成的字符串是所有可能性中字典序
    // 最小的，并返回这个字符串
    public static void question10(){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        String[] strings = new String[length];
        for(int i=0;i<length;i++){
            strings[i]=input.next();
        }
        quicksortString(strings,0,length-1);
        StringBuilder output = new StringBuilder();
        for(String s:strings){
            output.append(s);
        }
        output.trimToSize();
        System.out.print(output);
    }
    public static void quicksortString(String[] s1,int low,int high){
        if(low<high){
            int index =getIndex(s1,low,high);
            quicksortString(s1,0,index-1);
            quicksortString(s1,index+1,high);
        }
    }
    private static int getIndex(String[] arr,int low,int high){//求基准数组
        String temp=arr[low];
        while(low<high){
            //队尾元素大于基准数据的时候，向前移动high指针
            while(low<high&&temp.compareTo(arr[high])<=0){
                high--;
            }
            //此时high指针下的数据已经小于基准数据，赋值给low指针下的数据
            arr[low]=arr[high];
            while(low<high&&temp.compareTo(arr[low])>=0){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
    //最终解法，改写List的排序方式，当两两字符串之间的排序符合要求时，则全部符合要求（贪心算法思想）。
    public static void question102(){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        List<String> list=new ArrayList<String>();
        for(int i=0;i<length;i++){
            String s=input.next();
            list.add(s);
        }
       // quicksortString(strings,0,length-1);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1==o2){
                    return 0;
                }
                else{
                    return (o1+o2).compareTo(o2+o1);
                }
            }
        });
        //list.sort(String::compareTo);
        StringBuilder output = new StringBuilder();
        for(String s:list){
            output.append(s);
        }
        output.trimToSize();
        System.out.print(output);
    }
    public static void main(String[] args) {
    }
}
