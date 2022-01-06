package com.nlhui.study.Leetcode.bit;

/**
 * 位运算实现加减乘除
 * 不能出现+、-、*、 /
 * leetcode https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * https://leetcode-cn.com/problems/divide-two-integers/
 */
public class BitCalculate {
    /**
     * a^b  a异或b,相当于a和b的无进位相加
     * a&b 就是他们的进位
     * 让a=a' 也就是等于他们无进位相加的结果
     * b=b‘ 就是等于他们的进位
     * 最后结果 是无进位相加的结果加进位，所以继续无进位相加，继续求进位
     * 一直循环到进位=0
     * @param a
     * @param b
     * @return
     */

    //位运算实现加
    //支持负数
    public int add(int a, int b) {
        int sum=a;
        while (b!=0){
            sum=a ^ b;
            //左移是因为进位在下一位
            b=(a&b)<<1;
            a=sum;
        }
        return sum;
    }
    //将正数变为相反数
    public int negNum(int num){
        //取反加1
        return add(~num,1);
    }
    //位运算减
    public int minus(int a,int b){
        //减就等于 a+b的相反数 因为不能出现符号，所以先求相反数
        //或者直接 add(a,add((-b),1))
        return add(a, negNum(b));
    }
    //位运算乘
    public int multi(int a,int b){
        int res=0;
        //b=0 说明乘数已经没有了，乘完了
        while (b!=0){
            //乘数(b)与1相与，若不等于0，说明乘数最后一位为1，所以将此时的被乘数（a）放进结果
            if ((b&1)!=0){
                //切记赋值
                res=add(res,a);
            }
            //被乘数（a）左移一位，因为乘法中会补0
            a <<= 1;
            //乘数（b）右移一位，下一位与被乘数进行运算
            //>>>为不带符号右移  新出现的数将用0来补
            //若使用 >> 带符号右移 新出现的数将用符号位来补，若为负数，则一直补1，代码将无法结束
            b>>>=1;
        }
        return res;
    }

    //判断是否为负数
    public  boolean isNeg(int num){
        return num<0;
    }


    public int div(int a ,int b){
        //两个数都不能为负数，所以要为负数的话，先转为正数
        //用变量x,y 先当作 正数计算          一定要用x,y代替
        //
        int x=  isNeg(a) ? negNum(a) : a;
        int y =  isNeg(b) ? negNum(b) : b;
        int res=0;
        for (int i = 30; i >=0 ; i=minus(i,1)) {
            //a/b=c  假设c=0110  则a=2^1*b+2^2*b
            //让被除数（a）右移，直到大于等于除数（b）
            //让被除数右移而不是让除数左移是防止，再最后发现上一位才是符合条件的最后一个的时候，不顶出符号位
            if ((x>>i)>=y){
                //存下满足条件的那一位 例如 被除数右移三位时发现满足 则 让第三位等于1
                res |= (1<<i);
                // 原来的a减去b左移i位的结果 然后用这个结果继续判断
                //a=a-(b<<i);
                x=minus(x,(y<<i));
            }
        }
        // isNeg(a)^isNeg(b)   相与 说明若为真 则他们俩的符号不相同，一个为负数，所以返回结果的相反数
        // 符号相同的时候才为false,直接返回res
        //比较最初的符号  不是比较x,y
        return isNeg(a)^isNeg(b) ? negNum(res) : res;
    }

    public int divide(int dividend, int divisor) {
        /**
         * 有特殊情况，即 系统最小值没有对应的相反数  例如  -128~127
         * 所以有四种情况
         * 假设a为被除数  b为除数
         * 1.a和b都为系统最小值 直接返回1
         * 2.b为系统最小值  则结果接近0 根据取整原则，直接返回0
         * 3.a为系统最小值  则就较为复杂   做法在下面说明
         * 另外leetcode说明 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，
         * 如果除法结果溢出，则返回 231 − 1。
         *
         * 4.都不为最小值，直接调用上面的方法
         */
        if (dividend==Integer.MIN_VALUE&&divisor==Integer.MIN_VALUE){
            return 1;
        }else
        if (divisor==Integer.MIN_VALUE){
            return 0;
        }else
        if (dividend==Integer.MIN_VALUE){
            //若等于-1 ，根据leetcode规定返回系统最大值
            if (divisor==negNum(1)){
                return Integer.MAX_VALUE;
            }else {
                /**
                 * 先让被除数最小值+1 除以除数
                 * 再让除数乘以余数  ， 再算出 除数与余数乘积 与 被除数的差
                 * 再用他们的差 除以 除数  作为补偿
                 * 最后 将原来的余数 加上 补偿的余数
                 * 问题就解决了
                 * （a+1）/b =c
                 * a-(b*c)=d
                 * d/b=e
                 * res=c+e
                 */
                int c= div(add(dividend,1),divisor);
                int d= minus(dividend,multi(divisor,c));
                int e=div(d,divisor);
                return  add(c,e);}
        }else {
            return div(dividend,divisor);
        }

    }

    public static void main(String[] args) {
        BitCalculate bitCalculate = new BitCalculate();
        System.out.println(bitCalculate.divide(Integer.MIN_VALUE, 1));
    }
}