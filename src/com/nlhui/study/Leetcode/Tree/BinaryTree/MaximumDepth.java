package com.nlhui.study.Leetcode.Tree.BinaryTree;

//二叉树的最大深度
//leetcode  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

import sun.reflect.generics.tree.Tree;

public  class MaximumDepth {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    public  int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);
        treeNode.left.left.left=new TreeNode(8);
        MaximumDepth maximumDepth = new MaximumDepth();
        int length=maximumDepth.maxDepth(treeNode);
        System.out.println(length);
    }
}
