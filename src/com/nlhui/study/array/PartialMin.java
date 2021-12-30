package com.nlhui.study.array;

public class PartialMin {
    //找出一个局部最小的
    //将数组中的数想象成一个折线统计图   一段下降的趋势和一段上升的趋势之间必有最小值
    //两个前提要求 1.无序  2.相邻的两个数不相等
    public static int oneMinIndex(int[] arr){

        if (arr==null || arr.length==0){
            return -1;
        }
        if (arr.length==1){
            return 0;
        }
        int N=arr.length;
        if (arr[0]<arr[1]){
            return 0;
        }
        if (arr[N-1]<arr[N-2]){
            return N-1;
        }
        int L=0;
        int R=arr.length-1;
        //至少保证有三个数 L R-1 R 循环才会继续，否则只剩两个数，左边界和有边界，直接出循环进行比较
        //若只剩两个数 mid等于L，则mid-1就越界了
        while (L<R-1){
            int mid=(L+R)/2;
            //满足比左右都小
            if (arr[mid]<arr[mid+1]&&arr[mid]<arr[mid-1]){
                return mid;
            }else if (arr[mid]>arr[mid-1]){
                R=mid-1;
            }else if (arr[mid]>arr[mid+1]){
                L=mid+1;
            }
        }
        //只剩两个数，直接进行比较
        return arr[L]<arr[R] ? L : R ;

    }
    //对数器，生成随机数组
    public static int[] randomArray(int maxLength,int maxValue){
        int length= (int) (Math.random()*maxLength+1);
        int[] arr=new int[length];
        arr[0] =(int) (Math.random() * maxValue+1);
        for (int i = 1; i <length ; i++) {
            do {
                arr[i]=(int) (Math.random()*(maxValue+1));
            }while (arr[i]==arr[i-1]); //保证相邻数不相等，若与前一个数相同，重新进入循环获得值
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr=new int[]{4,2,4,6,5,7,3,7,9};
//        int[] arr1=new int[]{0,2,4,6,5,7,3,7,9};
//        int[] arr2=new int[]{3,2,3,5,1,4,7,6};
        //最后只剩L和R两个数，出循环直接进行比较
        int[] arr3=new int[]{3,2,3,2,3};
//        System.out.println(oneMinIndex(arr));
//        System.out.println(oneMinIndex(arr1));
//        System.out.println(oneMinIndex(arr2));
        System.out.println(oneMinIndex(arr3));
        System.out.println();

        int[] array = randomArray(9, 17);
        for (int j : array) {
            System.out.print(j + ",");
        }
        System.out.println();
        System.out.println(oneMinIndex(array));
    }
}
