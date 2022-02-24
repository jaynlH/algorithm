package com.nlhui.study.Leetcode.Tree.BinaryTree;


import java.util.HashMap;

/**
 * 从先序和中序遍历序列中构造二叉树
 * leetcode https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class IntroduceTreeFromPreAndIn {

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length){
            return null;
        }
       return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode f(int[] pre , int L1,int R1, int[] in,int L2,int R2){
         //有可能左树为空或右树为空
        if (L1>R1){
            return null;
        }
        TreeNode head = new TreeNode(pre[0]);
        if (L1==R2){
            return head;
        }
        int find=L2;
        while (in[find]!=pre[L1]){
            find++;
        }
        //find-L2 是   从第一个到find之前是几个数  例如  0 1 2 3  假设3是find 则0~3 一共3个数
        //此处是L1+1
        head.left=f(pre,L1+1,L1+(find-L2),in,L2,find-1);
        //L1+(find-L2)+1 是上次最后一个数的下一个数   因为是先序，所以从这个开始就是右边的树
        head.right=f(pre,L1+(find-L2)+1,R1,in,find+1,R2);
        return head;
        //若忘了，在新手班视频2小时03分讲解
    }



        //方法二
        //加入哈希表记录下中序序列的每个值

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        //把哈希表也传进去
        return g(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    //多加一张表，在递归的时候一直带着这张表

    public static TreeNode g(int[] pre , int L1,int R1, int[] in,int L2,int R2,HashMap<Integer,Integer> valueIndexMap){
        //有可能左树为空或右数为空
        if (L1>R1){
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1==R2){
            return head;
        }
        //找出 对应 先序中头节点的 索引
        int find=valueIndexMap.get(pre[L1]);
//        while (in[find]!=pre[L1]){
//            find++;
//        }
        //find-L2 是   从第一个到find之前是几个数  例如  0 1 2 3  假设3是find 则0~3 一共3个数
        //此处是L1+1
        head.left=g(pre,L1+1,L1+(find-L2),in,L2,find-1,valueIndexMap);
        //L1+(find-L2)+1 是上次最后一个数的下一个数   因为是先序，所以从这个开始就是右边的树
        head.right=g(pre,L1+(find-L2)+1,R1,in,find+1,R2,valueIndexMap);
        return head;
        //若忘了，在新手班视频2小时03分讲解
    }
}
