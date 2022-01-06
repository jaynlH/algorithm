package com.nlhui.study.Leetcode.Tree.BinaryTree;

/**
 * 对称二叉树
 * leetcode https://leetcode-cn.com/problems/symmetric-tree/
 */

public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);



    }
    public boolean isMirror(TreeNode p,TreeNode q){
       if (p==null^q==null){
           return false;
       }
       if (p==null&&q==null){
           return true;
       }
       return p.val==q.val&&isMirror(p.left,q.right)&&isMirror(p.right,q.left);


    }
}