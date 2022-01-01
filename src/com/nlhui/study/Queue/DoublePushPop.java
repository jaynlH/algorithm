package com.nlhui.study.Queue;

/**
 *实现一个双端队列
 * 功能：可以从头部加，从头部弹出；也可以从尾部加，尾部弹出
 */
//需要双链表才能实现
class DoubleNode<T>{
    T value;
    DoubleNode<T> last;
    DoubleNode<T> next;
    public DoubleNode(){}
    public DoubleNode(T value){
        this.value=value;
    }
}

public class DoublePushPop<T> {
    DoubleNode<T> head;
    DoubleNode<T> tail;
    int size;

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //从头插
    public void headPush(T value){
        DoubleNode<T> node = new DoubleNode<>(value);
        if (isEmpty()){
            head=node;
            tail=node;

        }else {
        node.next=head;
        head.last=node;
        head=node;}
        size++;
    }
    //从尾插
    public void tailPush(T value){
        DoubleNode<T> node = new DoubleNode<>(value);
        if (isEmpty()){
            head=node;
            tail=node;
        }else {
        tail.next=node;
        node.last=tail;
        tail=node;}
        size++;
    }
    public T headPop(){
        T cur=head.value;
        if (isEmpty()){
            return null;
        }
        //为只有一个元素的情况下，弹出后，让首尾都为空
        if (head==tail){
            head=null;
            tail=null;
            size--;

        }else {
            head = head.next;
            head.last = null;
            size--;
        }
        return cur;
    }
    public T tailPop(){
        T cur=tail.value;
        if (isEmpty()){
            return null;
        }
        //为只有一个元素的情况下，弹出后，让首尾都为空
        if (head==tail){
            head=null;
            tail=null;
            size--;
        }else {
        tail=tail.last;
        tail.next=null;
        size--;
        }
        return cur;
    }
}
