package com.nlhui.study;

import java.util.HashMap;
import java.util.TreeMap;

public class KnowHashMapTreeMap {
    //哈希表中非原生的类型，如Person类等自己定义的类，按引用传递，寻找内存地址
    //原生的类型 String,Integer等 按值传递
    public static void main(String[] args) {
        //哈希表  时间复杂度 O(1)
        HashMap<String, Object> map = new HashMap<>();
        //有序表  时间复杂度 O(logN)
        //内部会按KEY排好序
        //key一定是可以比较的
        //TreeMap的key是一定要可以比较的
        TreeMap<Integer, Object> treeMap = new TreeMap<>();
        treeMap.put(2,"nlh");
        treeMap.put(0,"yxy");
        treeMap.put(6,"mxt");
        treeMap.put(9,"lrx");
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        // <=7 ,输出离7最近的key
        System.out.println(treeMap.floorKey(7));
        // 输出>=5，离5最近的
        System.out.println(treeMap.ceilingKey(5));
    }

}
