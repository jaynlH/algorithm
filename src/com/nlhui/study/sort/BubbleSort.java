package com.nlhui.study.sort;

/**
 * 冒泡排序：
 * 从第一个数开始，与下一个数进行比较
 * 例如共有5个数
 * 第一次 0和1进行比较 第二次 1和2进行比较 第三次 2和3进行比较 第四次 3和4进行比较
 * 此方法，每轮排序最后一个数总是最大的，因此下一轮排序中可以将最后一个数忽略
 */
public class BubbleSort {
    //首先数组不能为空或者数组长度不能小于二，否则直接返回
    public static void bubbleSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        int N= arr.length;
        //因为每次排序后最后一个数会固定，因此从N-1开始
        //第一层循环相当于排序的范围
        for (int i = N-1; i >=0 ; i--) {
            //内训循环为具体排序操作
            //从1开始，与前一个进行比较，若比前面的数小，则进行交换
            //也可以从0开始，与后一个进行比较，则判断条件应为second<=i-1
            for (int second = 1 ; second<= i  ; second++) {
                    if (arr[second]<arr[second-1]){
                        swap(arr,second,second-1);
                    }
            }
        }

    }



    public static void swap(int[] arr,int a,int b){
        int temp= arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }

    public static void printArr(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,4,6,2,4,5,1,6,3,7};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }
}
