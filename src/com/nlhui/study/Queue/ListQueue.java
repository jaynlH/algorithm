package com.nlhui.study.Queue;

class Node<V>{
    V value;
    Node<V> next;
    public Node(){

    }
    public Node(V value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
//链表实现栈
public class ListQueue<V> {
    //队列需要头尾两个节点
    Node<V> head;
    Node<V> tail;
    int size;
    public ListQueue(){

    }
    public ListQueue(int size){
        this.size=0;
    }
    public ListQueue(int size,Node<V>head,Node<V> tail){
        this.size=0;
        this.head=null;
        this.tail=null;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        return false;
        }
        //元素入队列
    public void push(V value){
        Node<V> elem = new Node<V>(value);
        if (tail==null){
            head.next=elem;
            tail=elem;
        }else if (tail!=null){
            tail.next=elem;
            tail=elem;
        }
        size++;
    }
    //元素弹出队列
    public V pop(){
        V cur=null;
        if (head==null){
            //避免头越过尾巴
            tail=null;
        }else {
            cur = head.value;
            head = head.next;
            size--;
        }
        return cur;
    }
    //查看要弹出的值
    public V peek(){
        V cur=null;
        if (head!=null){
            cur=head.value;
        }
        return cur;
    }


    }


