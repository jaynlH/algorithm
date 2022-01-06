package com.nlhui.study.Tree.BinaryTree;

public class Realize {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(){};
        public Node(int  val){
            this.val=val;
        }
    }

    public static void pre(Node head){
        if (head==null){
            return ;
        }

        pre(head.left);
        System.out.println(head.val);
        pre(head.right);

    }


    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.right.right=new Node(5);
        pre(head);

    }
}
