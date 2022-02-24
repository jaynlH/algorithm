package com.nlhui.study.sort;

/**
 * 归并排序
 */
//方法一： 递归
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);

    }
    public static void process(int[] arr,int L,int R){
        if (L==R){
            return;
        }
        //向下取整

        int mid=L+((R-L)>>1);
        //左边是L不是0
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public  static void merge(int[] arr,int L,int mid,int R){
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        while (p1<=mid&&p2<=R){
                help[i++]= arr[p1]<=arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j <help.length ; j++) {
            arr[L+j]=help[j];
        }
    }


    //方法二： 非递归
    //此方法中一切边界都是为了防止数组长度接近Integer.MAX_VALUE,若溢出则为负数
    public static void mergeSort2(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        //步长  分左组、右组，每个组长度为step
        int step=1;
        int N=arr.length;
        //step==时退出，是因为等于的时候就没必要再去merge了
        while (step<N){
            int L=0;
            while (L<N){
                int mid=0;
                // 还能放下时，不然会溢出
                // N-1-L+1=N-L   当N-L大于等于step时  mid不会溢出
                if (N-L>=step){
                    //此时找出mid位置
                     mid=L+step-1;
                }else {
                    //若会溢出，则让mid等于最后一个数
                    mid=N-1;
                }
                //右组
                //接着找出R的位置，仍要考虑溢出的情况
                int R=0;
                //N-1-(mid+1)+1=  >=step
                if (N-mid-1>=step){
                    //R=(N-1)-(mid+1)+1=mid+step
                    R=mid+step;
                }else {
                    R=N-1;
                }
            merge(arr,L,mid,R);
                //下一组的L   一个组可能有很多小的左组和右组构成
                //若最右边已经是最后一个位置，则直接break
                if (R==N-1){
                    break;
                }else {
                    L=R+1;
                }

            }
            //若此时步长大于数组长度的一半，乘二后则可能溢出
            //不加=  是因为  长度为17（单数）时，除以二向下取整 比如长度为17时，除以二向下取整=8，可乘以二使step=16
            if(step>N/2){
                break;
            }else {
                step*=2;
            }

        }

    }
    public static void merge2(int[] arr,int L,int M,int R){
        if (L==R){
            return;
        }
        int[] help = new int[R-L+1];
        int p1=L;
        int p2=M+1;
        int i=0;
        while (p1<=M&&p2<=R){
            help[i++]= arr[p1]<=arr[p2]? arr[p1++]:arr[p2++];
        }
        //则p2已经越界
        while (p1<=M){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j <help.length ; j++) {
            arr[L+j]=help[j];
        }

    }



    public static void main(String[] args) {
        int[] ints = new int[]{2,3,5,3,6,3,7,8,3,5};
        mergeSort(ints);
        for (int i : ints) {
            System.out.print(i);
        }
    }
}
