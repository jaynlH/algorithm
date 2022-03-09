package com.nlhui.study.sort;

public class QuickSort {
//    public static void splitNum(int[] arr){
//        int LessRange=-1;
//        int BiggerRange=arr.length-1;
//        int last=arr.length-1;
//        int index=0;
//        while(index<BiggerRange){
//            if (arr[index]<arr[last]){
//                swap(arr,index++,++LessRange);
//            }else  if (arr[index] > arr[last]) {
//                swap(arr, --BiggerRange, index);
//            }else if(arr[index]==arr[last]){
//                index++;
//            }
//        }
//        swap(arr,BiggerRange,last);
//
//    }

    public static void quickSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        process(arr,0, arr.length-1);
    }

    public static  int[]  partition(int[] arr,int L,int R){
        int lessR=L-1;
        int index=L;
        int moreR=R;
        while(index<moreR){
            if (arr[index]<arr[R]){
                swap(arr,index++,++lessR);
            }else if(arr[index]>arr[R]){
                swap(arr,index,--moreR);
            }else {
                index++;
            }
        }
        swap(arr,R,moreR);
        //返回等于最后一个值的左边界和右边界
        return new int[]{lessR+1,moreR};

    }
    public static void process(int[] arr,int L,int R){
        if (L>=R){
            return;
        }
        //求出等于区的左右两边界,返回两个数
       int[] equalR= partition(arr, L, R);
        //equalR[0]为等于区的左边界
       process(arr,L,equalR[0]-1);
       //equalR[1]为等于区的右边界
       process(arr,equalR[1]+1,R);
    }


    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }

    public static void main(String[] args) {
        int[] arr={2,3,7,2,1,4,6,3,1,3};
        quickSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+",");
        }
    }


}