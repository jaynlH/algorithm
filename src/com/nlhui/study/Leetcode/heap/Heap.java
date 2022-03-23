package com.nlhui.study.Leetcode.heap;

public class Heap {
    private void heapInsert(int[] arr,int index){

        while(arr[index]>(arr[index-1]>>1)){
            swap(arr,index,((index-1)>>1));
        }
    }
    private void heapify(int[] arr,int heapSize,int index){
        int left=index*2+1;
        while (left<heapSize){
            int largest= left+1<heapSize&&arr[left]>=arr[left+1] ? left : left+1;
            largest= arr[index]>=arr[largest]? index : largest;
            if (largest==index){
                break;
            }
            swap(arr,index,largest);
            index=largest;
            left=index*2+1;
        }


    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[b]=arr[a];
        arr[b]=temp;
    }

    public static void main(String[] args) {
    }
}
