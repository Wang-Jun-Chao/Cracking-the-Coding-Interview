/**
 * Author: 王俊超
 * Date: 2016-01-07 22:14
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class MaxSum {
    public int getMaxSum(int[] A, int n) {
        int rs = Integer.MIN_VALUE;

        int cur = 0;
        for (int i : A) {

            if (cur>= 0) {
                cur += i;
            } else {
                cur = i;
            }

            if (cur > rs) {
                rs = cur;
            }
        }

        return rs;
    }
}
