package com.nlhui.study.Leetcode.Tree.BinaryTree;

/**
 * 相同的树
 * leetcode https://leetcode-cn.com/problems/same-tree/
 */


public class SameTree {
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
    public boolean isSameTree(TreeNode p, TreeNode q){
          //一个为空，一个不为空，则两棵树一定不相同
            //两棵树不相同为1 ，相同为0
          if (p==null^q==null){
              return false;
          }
          if (p==null&&q==null){
              return true;
          }
          //头节点相等 并且 左节点相等 并且 右节点相对
          return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }




}
