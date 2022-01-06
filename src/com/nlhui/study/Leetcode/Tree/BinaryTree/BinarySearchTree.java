package com.nlhui.study.Leetcode.Tree.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 验证搜索二叉树
 * leetcode https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class BinarySearchTree {
      public class TreeNode {
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
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }
    public static class Info{
          boolean isBST;
          int max;
          int min;
          public Info(){};
          public Info(boolean isBST,int max,int min){
              this.isBST=isBST;
              this.max=max;
              this.min=min;
          }
    }
    public Info process(TreeNode root){

          if (root==null){
              return null;
          }
        Info leftInfo= process(root.left);
        Info rightInfo=process(root.right);
        //最大最小值原本都等于他自己，以防返回null
        int max= root.val;
        int min= root.val;

        if (leftInfo!=null){
            max=Math.max(leftInfo.max, max);
            min=Math.min(leftInfo.min,min );
        }
        if (rightInfo!=null){
            //此时括号里的max和min已经是经过左树比较之后的
            max=Math.max(rightInfo.max, max);
            min=Math.min(rightInfo.min,min);
        }
        boolean isBST=true;
        //若左树不为空但已经不是搜索二叉树了，全局直接不是搜索二叉树
        if (leftInfo!=null&& !leftInfo.isBST){
            isBST=false;
        }
        if (rightInfo!=null&&!rightInfo.isBST){
            isBST=false;
        }
        //若为空，则认为true，否则比较值
        boolean leftMaxLess= leftInfo==null? true:(leftInfo.max< root.val);
        boolean rightMinMore= rightInfo==null? true:(rightInfo.min> root.val);
        //满足leftMaxLess&&rightMinMore，则满足搜索二叉树，取反则不满足
        //这句话的意思是，若不满足搜索二叉树的条件，置为false
        if (!(leftMaxLess&&rightMinMore)){
            isBST=false;
        }
        return new Info(isBST,max,min);
    }

}
