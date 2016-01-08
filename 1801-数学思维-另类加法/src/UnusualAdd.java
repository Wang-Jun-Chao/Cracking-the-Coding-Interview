/**
 * Author: 王俊超
 * Date: 2016-01-08 10:44
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class UnusualAdd {
    /**
     * 利用一位全加器进行运算
     * 设A、B为两位输入，C0为低位的进位信号，S为运算结果，C为向高位的进位，则可以列出全加器的真值表
     * A B C0	S	C
     * 0 0 0	0	0
     * 0 0 1	1	0
     * 0 1 0	1	0
     * 0 1 1	0	1
     * 1 0 0	1	0
     * 1 0 1	0	1
     * 1 1 0	0	1
     * 1 1 1	1	1
     * S = A^B^C
     * C = B&C0 | A&C0 | AB
     *
     * @param A
     * @param B
     * @return
     */
    public int addAB(int A, int B) {
        int rs = 0;
        int c0 = 0;
        int and = 1;

        for (int i = 0; i < 32; i++) {
            int a = A & and;
            int b = B & and;
            int s = a ^ b ^ c0;
            int c = (a & b) | (a & c0) | (b & c0);
            rs |= s;
            c0 = c;
            c0 <<= 1;
            and <<= 1;
        }

        return rs;
    }
}
