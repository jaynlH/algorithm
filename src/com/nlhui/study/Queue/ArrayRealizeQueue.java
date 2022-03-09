package com.nlhui.study.Queue;

public  class ArrayRealizeQueue {
    private int[] arrayQueue;
    private int pushi;
    private int polli;
    private int size;
    private final int limit;
    public ArrayRealizeQueue(int limit){
        arrayQueue=new int[limit];
        this.pushi=0;
        this.polli=0;
        this.size=0;
        this.limit=limit;
    }
    public void push(int num){
        if (size==limit){
            throw new IllegalArgumentException("the queue is full");
        }
        size++;
        arrayQueue[pushi]=num;
        pushi=nextInteger(pushi);
    }
    public int poll(){
        if (size==0){
            throw new IllegalArgumentException("there is nothing to pop");
        }
        size--;
        int num=arrayQueue[polli];
        polli=nextInteger(polli);
        return num;
    }

    public int nextInteger(int i){
        return i<limit-1 ? i+1 : 0;
    }


    public static void main(String[] args) {
       ArrayRealizeQueue arq=new ArrayRealizeQueue(5);
       arq.push(1);
       arq.push(3);
       arq.push(3);
       arq.push(3);
       arq.push(3);
       arq.poll();



        for (int i : arq.arrayQueue) {
            System.out.print(i+"");
        }
    }
}
