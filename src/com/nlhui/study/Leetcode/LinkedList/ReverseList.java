package com.nlhui.study.Leetcode.LinkedList;

import java.util.ArrayList;

/**
 * 反转链表
 * leetcode  剑指offer第24题
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */


//定义单链表结构
class Node{
     int value;
     Node next;
     public Node(){}
    public Node(int value){
        this.value=value;

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
class DoubleNode{
    int value;
    DoubleNode last;
    DoubleNode next;
    public DoubleNode(){}
    public DoubleNode(int value){
        this.value=value;
    }
}
//迭代法  单链表的反转
public class ReverseList {
    public static Node reverseList(Node head){
        //被指向的节点  最后被返回的 因为在迭代中，最后head(curr)为空了
        Node pre=null;
        //当前节点
        Node curr=head;
        // 存储下一个节点 让头节点移动
        Node next=null;
        while(curr!=null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
            return pre;

    }
//迭代法 双链表的反转
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode cur=head;
        DoubleNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            cur.last=next;
            pre=cur;
            cur=next;

        }
        return pre;
    }




    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<>();
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next= new Node(3);
//        while (head!=null){
//            System.out.println(head);
//            head=head.next;
//        }
        head=reverseList(head);
        System.out.println("反转后");
        while (head!=null){
            System.out.println(head);
            head=head.next;
        }
        System.out.println();
    }

}
