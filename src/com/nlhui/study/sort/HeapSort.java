package com.nlhui.study.sort;

public class HeapSort {
    public static void heapSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=0 ; i<arr.length;i++){
            heapInsert(arr,i);
        }

        int heapsize=arr.length;
        swap(arr,0,--heapsize);
//        heapify(arr,0,heapsize);
        while(heapsize>0){
//            swap(arr,0,--heapsize);
            heapify(arr,0,heapsize);
            swap(arr,0,--heapsize);
        }
    }

    public static void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index , (index-1)/2);
            index=(index-1)/2;
        }
    }

    public static void heapify(int[] arr,int index,int heapsize){
        int left=index*2+1;
        while(left<heapsize){
            //兄弟节点之间进行比较，选出大的那一个，进行下一步与父亲的比较
            int largest=  left + 1 <heapsize  && arr[left]>=arr[left+1] ? left : left+1 ;
//            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;

            //父子节点进行比较
            largest= arr[index] >= arr[largest] ? index : largest ;
            if(largest==index){
                break;
            }
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
