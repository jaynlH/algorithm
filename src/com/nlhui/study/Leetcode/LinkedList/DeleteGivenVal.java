package com.nlhui.study.Leetcode.LinkedList;


// leetcode 删除链表的节点
// https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/



public class DeleteGivenVal {
    public Node deleteGivenVal(Node head,int val){
        while(head!=null){
            if (head.value!=val){
                break;
            }
            head=head.next;
        }
        Node pre=head;
        Node cur=head;
        while(cur!=null){
            if (cur.value==val){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return head;

    }
}
