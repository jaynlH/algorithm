package com.nlhui.study.Leetcode.arrays;

public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums==null||nums.length==0){
            return 0;
        }
        long[] sum=new long[nums.length];
        sum[0]=nums[0];
        for (int i = 1; i < nums.length ; i++) {
            sum[i]=sum[i-1]+nums[i];
        }
        return process(sum,0,sum.length-1,lower,upper);
    }
    public static int process(long[] sum,int L,int R,int lower,int upper){
        if (L==R){
            return sum[L]>=lower&&sum[L]<=upper ? 1 : 0;
        }
        int mid=L+((R-L)>>1);
        int leftPart=process(sum,L,mid,lower,upper);
        int rightPart=process(sum,mid+1,R,lower,upper);
        return leftPart+rightPart+ merge(sum,L,mid,R,lower,upper);
    }

    public static int merge(long[] sum,int L,int M,int R,int lower,int upper){
        //不merge
        int windowL=L;
        int windowR=L;
        int res=0;
        for (int i = M+1; i <=R ; i++) {
            long min=sum[i]-upper;
            long max=sum[i]-lower;
            while (windowL<=M&&sum[windowL]<min){
                windowL++;
            }
            while (windowR<=M&&sum[windowR]<=max){
                windowR++;
            }
            res+=windowR-windowL;
        }
        long[] temp=new long[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        while (p1<=M&&p2<=R) {
            temp[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }
        while (p1<=M){
            temp[i++]=sum[p1++];
        }
        while (p2<=R){
            temp[i++]=sum[p2++];
        }
        for (int j = 0; j <temp.length ; j++) {
            sum[L+j]=temp[j];
        }
        return res;
    }
    }

