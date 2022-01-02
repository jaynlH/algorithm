package com.nlhui.study.Leetcode.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//合并k个升序链表
//https://leetcode-cn.com/problems/merge-k-sorted-lists/

public class MergeKSortList {
    public static class valCompare implements Comparator<ListNode>{


        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
    }




    public ListNode mergeKLists(ListNode[] lists) {
            //自己定义比较器
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new valCompare());
        if (lists==null||lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        //把每个链表的头节点放进去
        for (int i = 0; i < lists.length ; i++) {
            //先确定是不是为空或，若不是再添加
            if (lists[i]!=null)
            heap.add(lists[i]);
        }
        //判断是否加进去了，若没有则直接返回，说明链表都为空
        if (heap.isEmpty()){
            return null;
        }
        //经过heap的自动排序，最先弹出的会是最小的，让他作为整体的头节点
        ListNode head = heap.poll();
        //定义个节点代替head节点操作
        ListNode pre=head;
        //如果弹出的那个头节点下面还有元素就把头节点那一组链表的下一个节点放进堆
        if (pre.next!=null){
            heap.add(pre.next);
        }

        while (!heap.isEmpty()){
            //定义一个节点记录每一次弹出的
            ListNode cur= heap.poll();
            pre.next=cur;
            pre=cur;
            if (cur.next!=null){
                //把弹出的那个链表的下一个节点放进去
                heap.add(cur.next);
            }
        }
        return head;

    }

    }
}





