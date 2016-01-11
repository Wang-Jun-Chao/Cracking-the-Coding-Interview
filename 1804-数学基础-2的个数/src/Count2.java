/**
 * Author: 王俊超
 * Date: 2016-01-11 19:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Count2 {
    public int countNumberOf2s(int n) {
        int count = 0;
        int len = (n + "").length();

        for (int d = 0; d < len; d++) {
            count += count2InDigit(n, d);
        }

        return count;
    }

    /**
     * 求x的第d位上的2的个数，最低位为0
     *
     * @param n
     * @param d
     * @return
     */
    public int count2InDigit(int n, int d) {
        // 求第d位所对应的最小整数
        int powerOf10 = (int) Math.pow(10, d);
        // 求第d+1位对应的最小整数
        int nextPowerOf10 = powerOf10 * 10;
        // 求0...d位所对应的值
        int right = n % powerOf10;

        // 0...d位为0，且小于等于n，最接近n的数
        int roundDown = n - n % nextPowerOf10;
        // 0...d位为0，且大于大于等于n，最接近n的数
        int roundUp = roundDown + nextPowerOf10;

        // 求第d位数的值
        int v = (n / powerOf10) % 10;

        // 求第d位上2的个数
        if (v < 2) {
            return roundDown / 10;
        } else if (v == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }
}
