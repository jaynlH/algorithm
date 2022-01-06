package com.nlhui.study.Leetcode.Tree.BinaryTree;

public  class BalanceBinaryTree {
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
 
    public boolean isBalanced(TreeNode root) {
        return  process(root).isBalance;
    }
    public static class Info{
        boolean isBalance;
        int height;
        public Info(){};
        public  Info(boolean isBalance,int height){
            this.isBalance =isBalance;
            this.height=height;
        }
    }
    public Info process(TreeNode root){
        if (root==null){
            return new Info(true,0);
        }
            Info left = process(root.left);
            Info right= process(root.right);
            int height= Math.max(left.height, right.height)+1;
            boolean Balanced= left.isBalance&& right.isBalance
                    &&Math.abs(left.height- right.height)<2;
            return new Info(Balanced,height);
    }

    

}
