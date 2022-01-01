package com.nlhui.study.Leetcode.LinkedList;

import java.util.List;

/**
 * 两个链表中的数相加
 * 剑指offer|| 25
 * https://leetcode-cn.com/problems/lMSNwu/
 */
public class TwoListSum {
    //先求链表长度
    public  int listLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 可分为三个阶段
         * 1.  长链表和短链表中都还有
         * 2.  长链表中还有，短链表已经没了
         * 3.  长链表和短链表中都没有了，但是还有进位
         */
        int length1=listLength(l1);
        int length2=listLength(l2);
        //判断哪个是长链表，哪个是短链表
        //若链表一的长度大于等于链表二的，则l1为长链表 
        ListNode l= length1>=length2 ? l1 : l2;
        //若长链表为l1，则短链表为l2
        ListNode s=  (l==l1) ? l2 : l1;
        ListNode curL=l;
        ListNode curS=s;
        //不可忽略！表示着第三种情况下 谁来指着进位的那个节点  （若没有这个，两个节点在循环中已经指为null了）
        //last节点像一个幽灵，一直跟着长的那个链表
        ListNode last = curL;
        //表示进位
        int carry=0;


        //情况一，长短链表都不为空 curS不为空，则curL一定不为空
        while (curS!=null){
            carry= (curL.value+curS.value+carry)%10;
            curL.value= (curL.value+curS.value+carry)/10;
            last=curL;
            curS=curS.next;
            curL=curL.next;
        }
        //能到此循环，说明短链表中已经没有数了
        while (curL!=null){
            curL.value=(curL.value+carry)/10;
            carry= (curL.value+carry)%10;
            last=curL;
            curL=curL.next;

        }
        //第三种情况。长链表和短链表中都没数了，只剩进位，将进位创建一个节点
        while (carry!=0){
            //让长节点的最后一个节点指向这个进位
            last.next=new ListNode(carry);
        }
        return l;
    }
}