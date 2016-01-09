/**
 * Author: 王俊超
 * Date: 2016-01-07 13:28
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class CloseNumber {
    public int[] getCloseNumber(int x) {
        return new int[]{getPrev(x), getNext(x)};
    }

    /**
     * 找比n大的，二进制位数与n相同的最接近n的数
     *
     * @param n
     * @return
     */
    public int getNext(int n) {
        int c = n;
        // 翻转最右边但非拖尾的0，把这个位置记作p
        // c1为p右方连续l的个数，c0为p右方拖尾0的个数
        int c0 = 0;
        int c1 = 0;

        // 计算拖尾0的个数
        while ((c & 1) == 0 && (c != 0)) {
            c0++;
            c >>= 1;
        }

        // 计算从拖尾0的前一个位置开始，向前找，连续的1的个数
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }


        // 错误：若n == 11...1100...00，那么就没有更大的数字。且1的个数相同
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        // 最右边、非拖尾零的位置
        int p = c0 + c1;

        // 翻转最右边、非拖尾零
        n |= (1 << p);
        // 将p右方的所有位清零
        n &= ~((1 << p) - 1);
        // 在右方插入(c1-1)个1
        n |= (1 << (c1 - 1)) - 1;

        return n;
    }

    /**
     * 找比n小的，二进制位数与n相同的最接近n的数
     *
     * @param n
     * @return
     */
    public int getPrev(int n) {
        int c = n;
        // 翻转最右边但非拖尾的1，把这个位置记作p
        // c1为p右方拖尾l的个数，c0为p右方连续0的个数
        int c0 = 0;
        int c1 = 0;

        // 找拖尾1的个数
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        // 表明n的所有数的位数都是1
        if (c == 0) {
            return -1;
        }

        // 计算从拖尾1的前一个位置开始，向前找，连续的0的个数
        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        // 非拖一1的位置
        int p = c0 + c1;
        // 将n的后p+1位清零
        n &= ((~0) << (p + 1));
        // 掩码，最末c1+1位置1
        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);

        return n;
    }
}
