package com.nlhui.study.interviewQuestion;

//求数组有多少个逆序对，就是求右组有多少个比自己小的

public class ReversePair {
//    public static int mergeSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return 0;
//        }
//        return process(arr, 0, arr.length - 1);
//    }
//
//    public static int process(int[] arr, int L, int R) {
//        if (L == R) {
//            return 0;
//        }
//        int mid = L + ((R - L) >> 1);
//        return process(arr, L, mid)+
//        process(arr, mid + 1, R)+
//        merge(arr, L, mid, R);
//    }
//
//    public static int merge(int[] arr, int L, int mid, int R) {
//        int[] temp = new int[R - L + 1];
//        int i = 0;
//        int p1 = mid;
//        int p2 = R;
//        int count=0;
//        while (p1 >= L && p2 >= mid+1) {
//            count+= arr[p2]<arr[p1] ? (p2-mid) : 0;
//            //谁大拷贝谁
//            temp[i++] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
//        }
//        while (p1>=L) {
//            temp[i++] = arr[p1++];
//        }
//        while (p2 >= mid+1) {
//            temp[i++] = arr[p2++];
//        }
//        for (int j = 0; j < temp.length; j++) {
//            arr[L + j] = temp[j];
//        }
//        return count;
//    }

    public static  int reversePair2(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return process2(arr,0, arr.length-1);
    }
    public static int process2(int[] arr,int L,int R){
        if (L==R){
            return 0;
        }
        int mid=L+((R-L)>>1);
        return process2(arr,L,mid)+process2(arr,mid+1,R)+merge2(arr,L,mid,R);
    }
    public static int merge2(int[] arr,int L,int mid,int R){
        int[] temp=new int[R-L+1];
        int i=0;
        int p1=mid;
        int p2=R;
        int count=0;
        while (p1>=L&&p2>=mid+1){
            count+=arr[p2]<arr[p1] ? (p2-mid) : 0;
            temp[i++] = arr[p2] < arr[p1] ? arr[p1--] : arr[p2--];
        }
        while (p1>=L){
            temp[i--]=arr[p1--];
        }
        while (p2>=mid+1){
            temp[i--]=arr[p2--];
        }
        return count;

    }
}
