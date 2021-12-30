package com.nlhui.study.otherAlgo;

public class Print {
    public static void print(int num){
        for (int i = 31; i >=0 ; i--) {
            System.out.print( (num &(1<<i))==0 ? "0":"1");
        }
        System.out.println();


    }

    public static void main(String[] args) {
        int num=30;
//        print(num);
//        //带符号右移
//        print(num >> 1);
//        //不带符号右移
//        print(num >>> 1);
        int a=5;
        //相反数等于原来的数取反加一
        int b=(~a+1);
        print(a);
        print(b);
//        print(Integer.MIN_VALUE);



    }
}
