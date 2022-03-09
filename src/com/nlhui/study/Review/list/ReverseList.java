package com.nlhui.study.Review.list;

import com.nlhui.study.sort.InsertSort;
import com.nlhui.study.sort.MergeSort;

import java.util.Arrays;

class Node{
    public int value;
    public Node next;
    public Node(){};
    public Node(int value,Node node){
        this.value=value;
        this.next= node;
    }
}

class DoubleNode{
    public int value;
    public DoubleNode last;
    public DoubleNode next;
    public DoubleNode(){};
    public DoubleNode(int value,DoubleNode last,DoubleNode next){
        this.value=value;
        this.last=last;
        this.next=next;
    }

}


public class ReverseList {
    public static void reverseList(Node head){
        Node next=null;
        Node cur=head;
        Node pre=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
    }
    public static void reverseDoubleList(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode cur=head;
        DoubleNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            cur.last=next;
            pre=cur;
            cur=next;
        }


    }


    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr=new int[(int)(Math.random()*(maxSize+1))];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*(maxValue+1))-(int)(Math.random()*(maxValue+1));
        }
        return arr;
    }
    public  static int[] copyList(int[] arr){
        int[] copy = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            copy[i]=arr[i];
        }
        return  copy;

    }

    public static void main(String[] args) {
        int maxSize=100;
        int maxValue=100;
        int testTime=1000;
        boolean isSame=true;
        for (int i = 0; i <testTime ; i++) {
            int[] arr1=generateRandomArray(maxSize,maxValue);
            int[] arr2=copyList(arr1);
            MergeSort.mergeSort2(arr1);
            InsertSort.insertSort2(arr2);
            if (!Arrays.equals(arr1,arr2)){
                isSame=false;
                break;
            }
        }
        System.out.println(isSame ? "yes,you're right" : "something wrong");
    }



}


















