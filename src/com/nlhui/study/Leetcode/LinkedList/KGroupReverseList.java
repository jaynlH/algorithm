package com.nlhui.study.Leetcode.LinkedList;

import java.util.List;

/**
 * K个一组反转链表
 * leetcode第25题
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
class ListNode{
    int value;
    ListNode next;
    public ListNode(){}
    public ListNode(int value){
        this.value=value;

    }
public static  class KGroupReverseList {
        //主逻辑
        public ListNode reverseKGroup(ListNode head, int k) {
            //先用一个节点记录最初的头节点
            ListNode start=head;
            //得到第一次分组的end节点
            ListNode end=getKGroupEnd(head,k);
            //如果凑不齐第一组，则直接返回原头节点
            if (end==null){
                return head;
            }
            //反转后的头节点为原来的end节点
            //此操作也确定了全局的head节点
            head=end;
            //反转   也说明第一组凑齐了
            reverseGroup(start,end);

            //上一次反转后的最后一个节点 ，在第一次中也就是start 最初的头节点
            ListNode lastEnd=start;
            //若最后一个节点的下一个节点为空，说明没有下一组了
            while (lastEnd.next!=null){
                //这一组的第一个节点为上一组最后一个节点的下一个
                start=lastEnd.next;
                end=getKGroupEnd(start,k);
                //若不够k个，则结束，返回head节点可以去验证遍历了
                if (end==null){
                    return head;
                }
                //若够的话
                reverseGroup(start,end);
                //让上一组的最后一个节点指向当前组的第一个
                lastEnd.next=end;
                //新的lastEnd
                lastEnd=start;


            }
            return head;
        }
        //以k节点为一组，返回最后一个节点，若不够则返回原节点
    //第一个参数为起始节点，第二个为K个长度为一组
    public static ListNode getKGroupEnd(ListNode start,int K){
            //--k是为了控制k个为一组   start是为了防止不够k个的时候就为空，此情况下，返回null
            while (--K!=0&&start!=null){
                start=start.next;
            }
            return start;
        }

    public static void reverseGroup(ListNode start,ListNode end){
            //存起来，后面作为循环终止条件以及跳到的位置
                end=end.next;
                ListNode pre=null;
                ListNode cur=start;
                ListNode next=null;
                //注意边界问题，是到end截止，不是到null
                while (cur!=end){
                    next=cur.next;
                    cur.next=pre;
                    pre=cur;
                    cur=next;
                }
                //让反转后的最后一个指向下一组的第一个
                start.next=end;
            }
}





}
