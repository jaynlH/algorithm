package com.nlhui.study.Leetcode.Tree.BinaryTree;

/**
 * 路径总和ii
 * leetcode  https://leetcode-cn.com/problems/path-sum-ii/
 */

import java.util.ArrayList;
import java.util.List;

public class PathSumii {
     public  class TreeNode {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans  = new ArrayList<>();
        if (root==null){
            return ans;
        }
        List<Integer> tem = new ArrayList<>();
        process(root,tem,0,targetSum,ans);
        return ans;
    }
    public void process(TreeNode root,List<Integer> tem,int preSum,int targetSum,
                        List<List<Integer>> ans){
         //叶子节点时
         if (root.left==null&&root.right==null){
             if (preSum+root.val==targetSum){
                 //将此节点加入集合中
                 tem.add(root.val);
                 //将此集合copy一个然后加入大集合
                 ans.add(copyList(tem));
                 //清理现场，回到上一步
                 tem.remove(tem.size()-1);
             }
             //非叶子节点时
             preSum+= root.val;
             //将自己的值加入到集合
             //不能分别加到递归左右子树时，因为若同时有左右子树，将加入两次
             if (root.left!=null){
                 process(root.left,tem,preSum,targetSum,ans);
             }
             if (root.right!=null){
                 process(root.right,tem,preSum,targetSum,ans);
             }
             //最后返回调用者之前也清理现场
             tem.remove(tem.size()-1);
         }


    }
    public List<Integer> copyList(List<Integer> list){
        List<Integer> copy = new ArrayList<>();
        for (Integer integer : list) {
            copy.add(integer);
        }
        return copy;
    }
}
