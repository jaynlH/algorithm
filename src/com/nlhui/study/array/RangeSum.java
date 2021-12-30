package com.nlhui.study.array;

import javax.swing.*;

/**
 * 前缀和
 */
public class RangeSum {
    //定义一个前缀数组，用来存放0到该位置的累加和
    private int[] preArr;
    public void rangeSum(int[] arr){
        //先使前缀数组长度与原数组相同
        int[] preArr=new int[arr.length];
        //第一个的和就等于它本身
        preArr[0]=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            //使 0到当前的和 等于 0到前一个的和加上当前数
            preArr[i]=preArr[i-1]+arr[i];
        }

    }
    //求和
    public int printSum(int L ,int R){
        //使用三目运算符，若L（左边的数）从0开始，则0-R的和就等于preArr[R]本身
        //若L不为0，则用preArr[R]-preArr[L-1]
        //例如 3-7  preArr[7]表示0-7的和，preArr[3]表示0-3的和
        //preArr[7] 减去 preArr[2] 的差 就等于 3到7的和
        int sum= (L==0)? preArr[R] : preArr[R]-preArr[L-1];
        return sum;
    }


}



