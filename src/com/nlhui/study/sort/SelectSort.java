package com.nlhui.study.sort;

/**
 * 选择排序：
 * 将第一个数依次与后面所有数进行比较
 * 选出最小的放在第一个位置
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        //首先数组不能为空或者数组长度不能小于二，否则直接返回
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        //外层循环代表每一轮
        //例如 第一次排序 将 0到N-1之间的元素进行排序
        //第一次排完之后，第一个数就已经确定下来了，接下来是1到N-1进行排序
        //已经排完的就视为不存在
        //i<N-1是因为 j为i+1 所以不需要为 i<N
        //第一层循环相当于排序的范围
        for (int i = 0; i < N - 1; i++) {
            //将本次排序的第一个数的下标设为最小的下标
            int minValueIndex = i;
            //从第一个数的下一个数开始，因为不需要和自身进行比较
            for (int j = i + 1; j < N; j++) {
            //将当前下标对应的值与前面定义的最小下标对应的值进行比较
                //使用三目运算符，当前下标对应的值小于定义的最小下标对应的值，
                // 则使最小下标等于当前下标，否则不变
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            //进行交换
            swap(arr, i, minValueIndex);
        }
    }
    //交换方法
    public static void swap(int[] arr,int a,int b){
        int temp= arr[b];
        arr[b]=arr[a];
        arr[a]=temp;
    }
    //打印数组
    public static void printArr(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }
    //主方法进行测试
    public static void main(String[] args) {
            int[] arr=new int[]{1,4,6,2,4,5,1,6,3,7};
            printArr(arr);
            selectSort(arr);
            printArr(arr);
    }
}

