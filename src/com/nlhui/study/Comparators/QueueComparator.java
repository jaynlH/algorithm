package com.nlhui.study.Comparators;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueComparator {
    public static class QueueCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1>o2){
                return -1;
            }else if (o1<o2){
                return 1;
            }else {
                return 0;
            }
        }
    }


    public static void main(String[] args) {

        String s1="abc";
        String s2="abd";
        //若字符串的长度一样，则按ASCII编码大小比较
        System.out.println(s1.compareTo(s2));
        System.out.println("==========");
        String s3="abc";
        String s4="b";
        //若长度不一样，则会补成一样长度，用ASCII最低的补
        System.out.println(s3.compareTo(s4));


        //在构造器中定义自己的比较器  若没有则按从小到大
        PriorityQueue<Integer> heap = new PriorityQueue<>(new QueueCompare());
        heap.add(4);
        heap.add(2);
        heap.add(0);
        heap.add(1);
        //默认最小的出来
        System.out.println(heap.peek());
        System.out.println("============");
        while (!heap.isEmpty()){
            System.out.print(heap.poll()+"  ");
        }
        }
    }


