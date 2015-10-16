/**
 * 编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与到清零。
 * Author: 王俊超
 * Date: 2015-10-16
 * Time: 13:53
 * Declaration: All Rights Reserved !!!
 */
public class Solution07 {

    /**
     * 解法：用两个数组分别记录包含零元素的所有行和列。然后，在
     * 那二次遍历矩阵时，若所在行或列标记为零，则将元素清为零。
     *
     * @param matrix
     */
    public void setZeros(int[][] matrix) {
        // 假设输入的数据都是合法的
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // 记录值为0的元素所在行索引和列索引
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 若行i或者列j有个元素为0，则将matrix[i][j]设置为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用O(1)内存的解法
     *
     * @param matrix
     */
    public void setZeros2(int[][] matrix) {
        // 记录是否第0行要清零
        boolean row = false;
        // 记录是否第0列要清零
        boolean col = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // 将第0行和第0列用来标记其它行和列是否要清零
                if (matrix[i][j] == 0) {
                    // 第j列要设置为0
                    matrix[0][j] = 0;
                    // 第i行要设置为0
                    matrix[i][0] = 0;

                    // 第0行要清零
                    if (i == 0) {
                        row = true;
                    }
                    // 第0列要清零
                    if (j == 0) {
                        col = true;
                    }
                }
            }
        }

        // 将第0列以外的列清零
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 将第0行以外的行清零
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 将第0行清零
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // 将第0列清零
        if (col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
