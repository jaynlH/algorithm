package com.nlhui.study.sort;

import java.util.Arrays;
import java.util.Stack;

public class RandomQuickSort {
    //递归版本
    public static void quickSort1(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    public static int[] partition(int[] arr,int L,int R){
        if (L>R){
            return new int[]{-1,-1};
        }
        if (L==R){
            return new int[]{L,L};
        }
        int less=-1;
        int more=R;
        int index=0;
        while (index<more){
            if (arr[index]<arr[R]){
                swap(arr,index++,++less);
            }else if (arr[index]>arr[R]){
                swap(arr,index,--more);
            }else {
                index++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }
    public static void process(int[] arr,int L,int R){
        if (L>=R){
            return;
        }
        swap(arr,L+((int)(Math.random()*(R-L+1))),R);
        int[] equalR=partition(arr,L,R);
        process(arr,L,equalR[0]-1);
        process(arr,equalR[1]+1,R);
    }


    //迭代版本
    public static class Op{
        int l=0;
        int r=0;
        public Op(){}
        public Op(int left,int right){
            l=left;
            r=right;
        }
    }
    //迭代版本
    public static void quickSort2(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        int N=arr.length-1;
        swap(arr,(int)(Math.random()*(arr.length)),N);
        int[] equalR=partition(arr,0,N);
        int el=equalR[0];
        int er=equalR[1];
        Stack<Op> stack=new Stack<>();
        stack.push(new Op(0,el-1));
        stack.push(new Op(er+1,N));
        while (!stack.isEmpty()){
            Op op= stack.pop();
            if (op.l<op.r){
                swap(arr,op.l+(int)(Math.random()*(op.r-op.l+1)),op.r);
                int[] eq=partition(arr,op.l,op.r);
                int eql=eq[0];
                int eqr=eq[1];
                stack.push(new Op(op.l, eql-1));
                stack.push(new Op(eqr+1,op.r));
            }
        }
    }














    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void main(String[] args) {
        int testTime=1000;
        int maxArraySize=100;
        //想生成-100~100之间的数组就使maxValue=100,-20~20，就使maxValue=20;
        int maxValue=100;
        boolean succeed=true;
        for (int i = 0; i <testTime ; i++) {
            int[] arr1=generateRandomArray(maxArraySize,maxValue);
            int[] arr2=copyArray(arr1);
            InsertSort.insertSort1(arr1);
            quickSort2(arr2);

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
}
