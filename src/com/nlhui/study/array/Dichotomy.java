package com.nlhui.study.array;

import com.nlhui.study.sort.InsertSort;

/**
 * 二分查找
 *
 */
public class Dichotomy {
    public static boolean find(int[] arr,int num){
        //两个条件的意义是不同的，必须都写上
        if (arr==null||arr.length==0){
            return false;
        }
        //设置左右边界
        int L=0;
        int R=arr.length-1;
        while (L<=R){
            int mid=(L+R)/2;
            if (arr[mid]==num){
                return true;
            }else if (arr[mid]<num){
                L=mid+1;
            }else if (arr[mid]>num){
                R=mid-1;
            }
        }
        return false;
    }
    //数组有序，找出大于等于num的最左边的索引
    public static int LestestAndNoLessNumIndex(int[] arr,int num){
        if (arr==null||arr.length==0){
            return -1;
        }
        int L=0;
        int R=arr.length-1;
        int Tem=-1;//若整个数组没有符合要求的数，则最后输出维持-1的状态   如数组为1，2，3  ，要找的num为100
        while (L<=R){
            int mid=(L+R)/2;
            if (arr[mid]>=num){
                //先将当前满足条件的索引记录下来，以防边界移动后<num丢失最接近的下标
                Tem=mid;
                //有边界左移，寻找最接近的
                R=mid-1;
            }else if (arr[mid]<num){
                L=mid+1;
            }
            }

            return Tem;
        }
    //有序数组中找到<=num最右的位置
    public static int RightestAndNoBiggerNumIndex(int[] arr,int num){
        if (arr==null||arr.length==0){
            return -1;
        }
        int L=0;
        int R=arr.length-1;
        int tem=-1;
        while (L<=R){
            int mid=(L+R)/2;
            if (arr[mid]<=num){
                tem=mid;
                L=mid+1;
            }else if (arr[mid]>num){
                R=mid-1;
            }

        }
          return tem;
    }


    public static void main(String[] args) {
        int[] arr=new int[]{4,2,6,8,3,6,7,9,2,1,1};
        InsertSort.insertSort2(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(find(arr, 5));
        System.out.println(LestestAndNoLessNumIndex(arr, 6));
        System.out.println(RightestAndNoBiggerNumIndex(arr, 5));

    }
}
