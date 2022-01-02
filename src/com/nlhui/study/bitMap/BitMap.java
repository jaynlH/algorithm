package com.nlhui.study.bitMap;

/**
 * 位图
 * 好处：节省空间
 * 位图的基本功能
 */
public class BitMap {
    private long[] bits;

    public BitMap(int max){
        /**
         * 右移6位相当于除以64
         * max+64 是因为如果是0~0 至少也需要数组长度为一
         *  (max+64)/64  如果是0~0 则需要长度1  ；如果是0~63 则需要长度1；如果是0~64，则需要长度2
         */
        bits=new long[(max+64)>>6];
    }
    public void add(int num){
        /**
         * 左边 bits[num>>6] 是为了得到 该数存储在数组的哪个数中
         * 例如 186>>6 相当于 186/64 所以在 bits[2]中
         * 但是>> 、 >> 等效率高于 +、-、*、/等
         * 右边 (1L<<(num&63))
         * num&63 (63位前七位都为1 num是多少还是多少)  相当于num%64（0~63 总共6位） 但是&的效率高于%
         *
         * 1L<<(num&63) 是为了使num对应的哪个位置从0变为1
         *例如170&63 在 bit[2]的 42位   所以用1或42  则42位变为了1
         *   (1L)        0  ... 0 1
         *   1L<<42      1  ... 0 0
         *   (下标)       42 ... 0 1
         * bits[num>>6] |= (1L<<(num&63))  等于 bits[num>>6] = bits[num>>6] | (1L<<(num&63))
         *
         * 注意一定只可以用1L 不能用1   因为单独1只有32位，移动不到42位
         */
        bits[num>>6] |= (1L|(num&63));
    }

    public void delete(int num){
        /**
         *   例如删除170
         *   首先算出 他在 bits[2] 第42位  先让1左移42位， 让1的第42位为1,再取反，
         *   则1的第42位为0   再让bit[2] (因为未赋值，所以32位都为0) 和1 相与 则第42位为0 ，成功删除
         */
        bits[num>>6] &= ~(1L<<(num&63));
    }
    public boolean isContain(int num){

       return (bits[num>>6] & (1L<<(num&63)))!=0;

    }
}
