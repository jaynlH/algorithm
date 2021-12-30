package com.nlhui.study.array;

/**
 * 对数器
 *生成随机样本，进行比对
 */
public class DuiShuQi {
    //返回一个数组，数组长度[0,maxValue],数组的值[0,maxValue]
   public static int[] LengthRandomValueRandom(int maxLength,int maxValue){
       //初始化数组时长度随机   maxLength+1才能保证右闭
       int[] arr=new int[(int) (Math.random()*(maxLength+1))];
       for (int i = 0; i < arr.length; i++) {
           arr[i]= (int) (Math.random()*(maxValue+1));
       }
       return arr;
   }

    public static void main(String[] args) {
        int[] ints = LengthRandomValueRandom(10, 8);
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(ints[i]);
        }
        System.out.println();


    }
}
