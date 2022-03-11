package com.nlhui.study.interviewQuestion;

// 求累计的小和

public class SmallSum {
    public static int smallSum(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr,int L,int R){
        if (L==R){
            return 0;
        }
        int M=L+((R-L)>>1);
        return process(arr,L,M)+process(arr,M+1,R)+merge(arr,L,M,R);
    }
    public static int merge(int[] arr,int L,int M,int R){
        int[] help=new int[(R-L)+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        int res=0;
        while (p1<=M&&p2<=R){
            //此行不用p1++，下面一行会++
            res+= arr[p1]<arr[p2] ? (R-p2+1)*arr[p1] : 0;
            //此题目左右相等时应先拷贝右边的，因为可能右边有比他大的
            help[i++]= arr[p1]<arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=M){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j <help.length; j++) {
            arr[L+j]=help[i++];
        }
        return res;
    }


    public static int smallSum2(int[] arr){
        if (arr==null||arr.length<2){
            return 0;
        }
        return  process2(arr,0,arr.length-1);
    }
    public static int process2(int[] arr,int L,int R){
        //base case
        if (L==R){
            return 0;
        }
        int mid=L+((R-L)>>1);
        return  process2(arr,L,mid)+process2(arr,mid+1,R)+merge2(arr,L,mid,R);
    }
    public static int merge2(int[]arr,int L,int mid,int R){
        int[] temp=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        int res=0;
        while (p1<=mid&&p2<=R){
            res+= arr[p1] < arr[p2] ? arr[p1]* (R-p2+1) : 0;
            temp[i++]= arr[p1] <arr[p2]  ? arr[p1++] : arr[p2++];
        }
        while (p1<=mid){
            temp[i++]=arr[p1++];
        }
        while (p2<=R){
            temp[i++]=arr[p2++];
        }
        for (int j = 0; j < temp.length ; j++) {
            arr[L+j]=temp[j++];
        }
        return res;

    }

}
