package com.nlhui.study.otherAlgo;

public class MathRandom {
    //Math.random()函数的使用(默认返回 [0,1)范围上的  )
    //要在指定范围随机生成数  Math.random()*(max-min)+min
    //Math.random()输出的每个数的结果是等概率的
    public static void main(String[] args) {
        int K=8;
        int testTime=10000;
        int count1=0;
        int[] count2=new int[9];
//        for (int i = 0; i <testTime ; i++) {
//            if (Math.random()<0.5){
//                count1++;
//            }
//        }
//        System.out.println(((double)count1/(double)testTime));

        System.out.println("================");
        /**
         * 指定范围的数生成的次数及概率
         */
        for (int i = 0; i < testTime; i++) {
            int ans= (int) (Math.random()*K);
            count2[ans]++;
        }
        for (int i = 0; i <K ; i++) {
            System.out.println(i+"这个数出现了"+count2[i]+"次");
            double proba=(double)(count2[i])/(double)(testTime);
            System.out.println(i+"出现的概率为"+proba);
        }
        System.out.println("============");

        int count=0;
        for (int i = 0; i < testTime; i++) {
            if (xToxpower2()<0.6){
                count++;
            }
        }
        System.out.println((double)count/(double) testTime);
        System.out.println("==================");
        System.out.println("随机函数练习1");

        count=0;
        for (int i = 0; i <testTime ; i++) {
            //为1，2的概率
            if (f2()==0){
                count++;
            }
        }
        System.out.println((double) count/(double)testTime);
        System.out.println(f3());
        System.out.println("====================");
        System.out.println();
        count2=new int[8];
        for (int i = 0; i <testTime ; i++) {
            int ans;
            ans=f4();
            count2[ans]++;
        }
        for (int i = 1; i <count2.length ; i++) {
            System.out.println(i+"这个数出现了"+count2[i]+"次");
        }
        System.out.println("==================");
        System.out.println("随机函数练习2");
        count2=new int[57];
        for (int i = 0; i <testTime+100000 ; i++) {
            int ans=g5();
            count2[ans]++;
        }
        for (int i = 17; i <57 ; i++) {
            System.out.println(i+"这个数出现了"+count2[i]+"次");
        }
        System.out.println("========");
        System.out.println("已知0和1的概率不同，要求借助条件等概率返回0和1");
        int sum=0;
        for (int i = 0; i <testTime ; i++) {
            if (h2()==0){
                sum++;
            }
        }
        System.out.println(sum);
    }

    /**
     * 返回[0,1)上的任意一个小数
     * x属于[0,1)，将[0,x)范围上的数出现的概率由原来的x变为x平方
     * 例如[0,0.3)原来的概率为0.3，变为0.09
     * @return
     */
    public static double xToxpower2(){
        //例如[0,0.3) 的x^2概率
        // 两次随机数都得在 [0,0.3)的范围里 ，x的数越大，出现的概率越高
        return Math.max(Math.random(),Math.random());
    }
    //概率为3次方
     public static double xToxpower3(){
        return Math.max(Math.max(Math.random(),Math.random()),Math.random());
    }

    /**
     * 随机函数
     * 给出一个函数1~5是等概率的，实现一个函数求出1~7也是等概率的,只能借助1-5这个函数
     */

    public static int f1(){
        //随即返回1-5中的一个整数
        return (int)(Math.random()*5)+1;
    }

    /**随即机制，只能用f1
     * 等概率返回0和1
     * 作为0和1的等概率发生器
     * @return
     */
    public static int f2(){
        int ans=0;
        //若随机数为3，则一直进行循环
        do {
            ans=f1();
        }while (ans==3);
        //若为1，2 则返回0 ； 若为4，5，则返回1
        return ans<3 ? 0 : 1;

    }
    //等概率返回000~111  等概率0~7返回一个
    public static int f3(){
        int ans;
        return ans=(f2()<<2)+(f2()<<1)+(f2());

    }
    //1~7等概率返回
    public static int f4(){
        int ans;
        do {
            ans=f3();
        }while (ans==0);//若f3()得出的为0，则继续循环
        return ans;
    }

    /**
     * 随机函数练习
     * 给出一个函数3~19是等概率的，实现一个函数求出 17~56也是等概率的，只能借助3~19这个函数
     */
    public static int g1(){
        //因为是整数，所以要使19也能返回，应该设右闭的大一个
        return (int) (Math.random()*17+3);
    }
    //等概率返回0和1
    public static int g2(){
        int ans;
        do {
            ans=g1();
        }while (ans==11); //等于11也继续循环
            //3-10为0  12-19为1
        return ans<11 ? 0 : 1;
    }
    //56-17 目标是0-39范围上，最后再加个17  需要6个二进制位
    //等概率返回0~63
    public static int g3(){
        int ans;
        return ans=(g2()<<5)+(g2()<<4)+(g2()<<3)+(g2()<<2)+(g2()<<1)+(g2());
    }
    //等概率返回0-39范围的数
    public static int g4(){
        int ans;
        do {
            ans=g3();
        }while (ans>39);//若大于39，则继续循环
        return ans;
    }
    //等概率返回17-56范围上的
    public static int g5(){
        return g4()+17;
    }

    //已知0和1的概率不同，要求借助条件等概率返回0和1
    public static int h1(){
        return Math.random()>0.17 ? 0 : 1;
    }
    //等概率返回0和1
    //思路，若同时返回0，或同时返回一则继续循环，直到一次0一次1
    public static int h2(){
        int ans;
        do {
            ans=h1();
        }while (ans==h1()); //若第一个数与第二个数相同，则继续循环，注意是==不是=
        //ans的结果只会为 先为0 后为1 则返回1  或  先为1 后为0 返回0
        //所以ans 得到0和1是等概率的
        return ans;
    }



}
