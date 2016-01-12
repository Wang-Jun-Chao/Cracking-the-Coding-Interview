/**
 * Author: 王俊超
 * Date: 2016-01-12 13:18
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class SubMatrix {
    public int sumOfSubMatrix(int[][] mat, int n) {

        // 矩阵的行数
        int rowCount = mat.length;
        // 矩阵的列数
        int colCount = mat[0].length;

        // 部分和
        int[] partialSum = new int[colCount];
        // 最大值
        int maxSum = Integer.MIN_VALUE;

        // rowStart限制开始处理的行
        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            // 对部分知清零
            clear(partialSum);

            // 下面对[rowStart,...,rowEnd]列表进行处理
            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
                // 对所有的列进行处理
                for (int col = 0; col < colCount; col++) {
                    // partialSum[col]的值是mat[rowStart...rowEnd][col]行累加的值
                    partialSum[col] += mat[rowEnd][col];
                }

                // 在此处partialSum[rowStart,...,rowEnd]数组就是
                // mat[rowStart,...,rowEnd][0,...,colCount-1]就对列的累加

                // 此处的tempMaxSum就是mat[rowStart,...,rowEnd][x,...,y]的某个值
                // 其中0<=x<=y<=(colCount-1)
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
