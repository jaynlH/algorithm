package com.nlhui.study.Leetcode.Tree.BinaryTree;

/**
 * 路径综合
 * leetcode https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {
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
    //设置全局变量
    public static boolean isTarget=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        //因为是全局变量，所以在每棵树开始前先置为false
        isTarget=false;
        process(root,0,targetSum);
        return isTarget;
    }
    public void process(TreeNode root,int preSum,int targetSum){
        //当是叶子节点的情况
        if (root.left==null&&root.right==null){
            //从始至终只有当节点是叶子节点，且路径总和等于目标总和时才将isTarget置为true
            if (preSum+ root.val==targetSum){
                isTarget=true;
            }
            return;
        }
        //非叶子节点时
        preSum+= root.val;
        //一定要有此条件，不然不是叶子节点的节点满足目标总和也会置为true，例如一个节点左边没子节点，右边有子节点
        if (root.left!=null){
            process(root.left,preSum,targetSum);
        }
        if (root.right!=null){
            process(root.right,preSum,targetSum);
        }
    }
}
