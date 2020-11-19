package com.string;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//编写一个计算器，支持加减乘除三种符合和括号
//第一种，使用解析器，解析。
public class StringQuestion5 {
    public static  void caculate1() throws ScriptException {
        Scanner scanner = new Scanner(System.in);
        String s =scanner.nextLine();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine js = manager.getEngineByName("js");
        System.out.println(js.eval(s));
    }
    //第二种，使用栈进行求解
    public static  void caculate2(){
        Scanner scanner = new Scanner(System.in);
        String s =scanner.nextLine();
        Stack<Integer> stack=new Stack();
        List<String> list=transformRPN(s);
        for(String c:list){
            switch (c){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second-first);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int first1=stack.pop();
                    int second1=stack.pop();
                    stack.push(second1-first1);
                    break;
                default:
                   stack.push(Integer.parseInt(c));
            }
        }
        System.out.print(stack.pop());
    }
    public static List<String> transformRPN(String s){
        Stack<String> stack=new Stack();
        List<String> list=new ArrayList();
        for(int i=0;i<s.length();i++){
            String a =String.valueOf(s.charAt(i));
            switch (a){
                case "+":
                case "-":
                case "*":
                case "/":
                    while(!stack.empty()&&precedence(a)<=precedence(stack.peek())){
                        list.add(stack.pop());
                    }
                    stack.push(a);
                    break;
                case "(":
                    stack.push(a);
                    break;
                case ")":
                    while(!stack.empty()&&!stack.peek().equals("(")){
                        list.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    int num=Integer.parseInt(a);
                    while(i<s.length()-1&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0'){
                        num=num*10+s.charAt(i+1)-'0';
                        i++;
                    }
                    list.add(String.valueOf(num));
            }
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
    public static int precedence(String a){
        if(a.equals("+")||a.equals("-")){
            return 1;
        }
        else if(a.equals("*")||a.equals("/")){
            return 2;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args) throws ScriptException {
        caculate2();
    }
}
