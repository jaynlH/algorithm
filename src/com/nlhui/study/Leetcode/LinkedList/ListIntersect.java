package com.nlhui.study.Leetcode.LinkedList;

import java.awt.*;

/**
 * 链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class ListIntersect {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode Pa=headA;
        ListNode Pb=headA;
        while (Pa!=Pb){
            //只要走相同路程。最后一定会相遇
            //A节点走完，则指向HeadB
            Pa= Pa==null? headB : Pa.next;
            Pb= Pb==null? headA : Pb.next;
        }
        return Pa;


    }
}
