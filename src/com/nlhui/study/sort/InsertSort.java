package com.nlhui.study.sort;

import java.util.Arrays;

/**
 * 插入排序：
 * 从第二个数开始依次与前面进行比较
 * 例如四个数  3，4，5，1
 * 若轮到1进行比较  1与5进行比较，1<5,交换位置   1继续与4进行比较，1<4交换位置，以此类推，
 * 直到下标为0或前一个数小于当前数
 * 若当前数小于前面一个数则不需再比较，因为前面的顺序已排好
 */
public class InsertSort {
    //=========方法一
    public static void insertSort1(int[] arr){
        //首先数组不能为空或者数组长度不能小于二，否则直接返回
        if (arr==null||arr.length<2){
            return;
        }
        int N=arr.length;
        //从第一个数开始，一直到最后一个数
        //第一层循环相当于排序的范围
        for (int i = 1; i <N ; i++) {
            //将当前数下标设为第一个数的下标
            int firstIndex=i;
            //进行一个while循环，循环条件是下标不能为负数并且当前数小于前一个数，有一个不满足则终止
            //若进入循环，交换之后，需要对下标-1，进行该数与另一个数的比较
            while (firstIndex>0&&arr[firstIndex]<arr[firstIndex-1]){
                swap(arr,firstIndex,firstIndex-1);
                firstIndex--;
            }
        }
    }
    //=========方法二
    public static void insertSort2(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        int N=arr.length;
        for (int i = 1; i <N ; i++) {
            //例如 1 3 4 2 7
            //本来按方法一应该用2与前面一次比较， 但此方法，将4设为那个key，先确保下标不为负
            //再与2进行比较，因为4>2因为4和2交换位置 此时为 1 3 2 4
            //再将key设为3 ，与2比较
            //*******就让key一直为要插入的那个数的前一个******
            for (int pre = i-1; pre >=0&&arr[pre]>arr[pre+1] ; pre--) {
                swap(arr,pre,pre+1);
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
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    /**
     * 对数器！！！！！！！！！！！！！
     * 可当测试工具，测试用例 online judge
     * @param args
     */
    public static void main(String[] args) {
        int testTime=1000;
        int maxArraySize=100;
        //想生成-100~100之间的数组就使maxValue=100,-20~20，就使maxValue=20;
        int maxValue=100;
        boolean succeed=true;
        for (int i = 0; i <testTime ; i++) {
            int[] arr1=generateRandomArray(maxArraySize,maxValue);
            int[] arr2=copyArray(arr1);
            insertSort1(arr1);
            RandomQuickSort.quickSort1(arr2);
            //BubbleSort.bubbleSort(arr2);
            if (!Arrays.equals(arr1,arr2)){
                   succeed=false;
                   break;
            }
        }
        System.out.println(succeed ? "ok,you're right!": "something wrong!" );
    }
    public static int[] generateRandomArray(int maxArraySize,int maxValue){
        //Math.random()*N 是 随机[0,N),不包含N
        //要使能取到N，就 Math.random()*(N+1) 转换成int 类型，范围就成了 [0,N]
        int[] arr= new int[(int)(Math.random()*(maxArraySize+1))];
        for (int i=0;i<arr.length;i++){
            //为了不止可以取到正值，使用两个随机数相减，结果可能为正值，可能为0，可能为负数
            arr[i]=(int) (Math.random()*(maxValue+1))-(int) (Math.random()*(maxValue+1));
        }
        return  arr;
    }
    public static int[] copyArray(int[] arr){
        int[] copy = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            copy[i]=arr[i];
        }
        return copy;
    }

//    public static boolean isEqual(int[] arr1,int[] arr2){
//        boolean is=true;
//        for (int i = 0; i < arr1.length ; i++) {
//            if (arr1[i]!=arr2[i]){
//                is=false;
//                break;
//            }
//        }
//        return  is;
//    }
}
