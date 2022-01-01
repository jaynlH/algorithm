package com.nlhui.study.Leetcode.arrays;

import java.util.HashMap;

/**
 * 两数之和
 * leetcode第1题
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //创建哈希表，第一个为数，第二个为数所对应的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int length= nums.length;
        for (int i = 0; i <length ; i++) {
            //先算出要找的匹配的数是多少
            int anotherNum=target-nums[i];
            //若该数再map中，且下标不等于自己本身，则满足条件返回他们两个的下标
            if (map.containsKey(anotherNum)&&i!=map.get(nums[i])){
                //注意输出顺序，因为得先有anotherNum在里面，才能满足条件，因为anotherNum的索引在前
                return new int[]{map.get(anotherNum),i};
            }
            //若要找的数不在哈希表里，则将遍历到的数放入map

            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("未找到");
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums=new int[]{3,3};
        int target=6;
        for (int i : twoSum.twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}

