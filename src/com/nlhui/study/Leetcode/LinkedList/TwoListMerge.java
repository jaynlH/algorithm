package com.nlhui.study.Leetcode.LinkedList;

/**
 *合并两个有序链表
 * leetcode 21
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

public class TwoListMerge {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //先判断是否为空  若为空，直接返回另一个链表
        if (list1==null||list2==null){
            return list1==null ? list2 : list1;
        }
        //判断两个链表头结点的值，决定哪个做整体的头节点
       ListNode head= list1.value>= list2.value ? list2 : list1;
        //做头节点的那个链表  第一个节点就是头节点的下一个节点
       ListNode cur1=head.next;
       //没做头节点的那个链表 他的第一个节点就是头节点
       ListNode cur2= head==list1 ? list2 : list1;
       //定义一个节点等于头节点

       ListNode pre=head;
       while (cur1!=null&&cur2!=null){
           if (cur1.value<=cur2.value){
               pre.next=cur1;
               cur1=cur1.next;
           }else if (cur1.value> cur2.value){
               pre.next=cur2;
               cur2=cur2.next;
           }
           //来到自己的下一位
           pre=pre.next;
       }
       pre.next= cur1==null ? cur2 : cur1;

       return head;
    }


}
