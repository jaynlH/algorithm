package com.nlhui.study.Review.sort;

import com.nlhui.study.sort.QuickSort;

import java.util.Arrays;

public class MergeSort {
    public static void  newMergeSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);

    }
    public static void process(int[] arr,int L,int R){
        if (L==R){
            return;
        }
        int mid=L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int L,int M,int R){
            int[] help=new int[R-L+1];
            int i=0;
            int p1=L;
            int p2=M+1;
            while (p1<=M&&p2<=R){
                help[i++]= arr[p1]<=arr[p2] ? arr[p1++] : arr[p2++];
            }
            while (p1<=M){
                help[i++]= arr[p1++];
            }
            while (p2<=R){
                help[i++]=arr[p2++];
            }
        for (int j = 0; j < help.length ; j++) {
            arr[L+j]=help[j];
        }

    }

    public static void newMergeSort2(int[]arr){
        if (arr==null&&arr.length<2){
            return;
        }
        int N=arr.length;
        int step=1;
        while(step<N){
            int L=0;
            while(L<N){
                int M=0;
                if (N-L>=step){
                    M=L+step-1;
                }else {
                    M=N-1;
                }
                int R=0;
                if (N-M-1>=step){
                    R=M+step;
                }else {
                    R=N-1;
                }
                merge(arr,L,M,R);
                if (R==N-1){
                    break;
                }else {
                    L=R+1;
                }
            }
            if (step<=N/2){
                step*=2;
            }else {
                break;
            }
        }
    }


    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr=new int[(int)(Math.random()*(maxSize+1))];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int) (Math.random()*(maxValue+1))-(int) (Math.random()*(maxValue+1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime=1000;
        int maxSize=100;
        int maxValue=100;
        boolean isSame=true;
        for (int i = 0; i <testTime ; i++) {
            int[] arr1=generateRandomArray(maxSize,maxValue);
            int[] arr2=copy(arr1);

            newMergeSort2(arr1);
            QuickSort.quickSort(arr2);
            if (!Arrays.equals(arr1,arr2)){
                isSame=false;
            }
        }
        System.out.println(isSame? "yes":"no");
    }
    public static int[] copy(int[] arr){
        int[] help = new int[arr.length];
        for (int i = 0; i <help.length ; i++) {
            help[i]=arr[i];
        }
        return help;
    }
}
