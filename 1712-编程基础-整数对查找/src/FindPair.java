import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-07 22:29
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class FindPair {
    public int countPairs(int[] A, int n, int sum) {
        // 先对数组进行排序
        Arrays.sort(A);
        return countPairs(A, 0, A.length - 1, sum);
    }

    public int countPairs(int[] A, int beg, int end, int sum) {
        int rs = 0;
        int lo = beg;
        int hi = end;

        while (lo < hi) {
            if (A[lo] + A[hi] == sum) {
                int i = lo;
                while (i < hi && A[lo] == A[i]) {
                    i++;
                }
                int j = hi;
                while (i <= j && A[j] == A[hi]) {
                    j--;
                }


                rs += (i - lo) * (hi - j);

                // 最中间有多个数，并且这两个数相加相等
                if (A[lo] == A[hi]) {
                    // 左边的下标向右移动，右边的不需要移动
                    lo++;
                }
                // 两个数不相同
                else {
                    // 分别移动到新的位置，指向新的不同的数字
                    lo = i;
                    hi = j;
                }
            } else if (A[lo] + A[hi] < sum) {
                lo++;
            } else {
                hi--;
            }
        }

        return rs;
    }
}
