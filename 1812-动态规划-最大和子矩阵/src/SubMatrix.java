/**
 * Author: 王俊超
 * Date: 2016-01-12 13:18
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class SubMatrix {
    public int sumOfSubMatrix(int[][] mat, int n) {

        int rowCount = mat.length;
        int colCount = mat[0].length;

        int[] partialSum = new int[colCount];
        int maxSum = Integer.MIN_VALUE;

        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            clear(partialSum);
            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
                for (int col = 0; col < colCount; col++) {
                    partialSum[col] += mat[rowEnd][col];
                }

                int tempMaxSum = maxSubArray(partialSum);
                if (tempMaxSum > maxSum) {
                    maxSum = tempMaxSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * 将数组清零
     *
     * @param a
     */
    public void clear(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
    }

    /**
     * 求数组的最大的子数组的和
     *
     * @param a
     * @return
     */
    public int maxSubArray(int[] a) {
        int max = Integer.MIN_VALUE;
        int v = 0;

        for (int i : a) {
            v += i;
            if (v > max) {
                max = v;
            }

            if (v < 0) {
                v = 0;
            }
        }

        return max;
    }
}
