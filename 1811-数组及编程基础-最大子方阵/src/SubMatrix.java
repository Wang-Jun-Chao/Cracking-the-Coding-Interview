/**
 * Author: 王俊超
 * Date: 2016-01-12 10:25
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class SubMatrix {
    public int maxSubMatrix(int[][] mat, int n) {
        for (int i = mat.length; i >= 1; i--) {
            int size = findSquareWithSize(mat, i);
            if (size > 0) {
                return size;
            }
        }

        return 1;
    }

    public static class Cell {
        private int right = 0;
        private int below = 0;
    }

    public int findSquareWithSize(int[][] mat, int size) {
        int count = mat.length - size + 1;
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(mat, row, col, size)) {
                    return size;
                }
            }
        }

        return 0;
    }

    private boolean isSquare(int[][] mat, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            if (mat[row][col + 1] == 1) {
                return false;
            }

            if (mat[row + size - 1][col + i] == 1) {
                return false;
            }
        }

        for (int i = 0; i < size; i++) {
            if (mat[row + i][col] == 1) {
                return false;
            }

            if (mat[row + size - 1][col] == 1) {
                return false;
            }
        }

        return true;
    }
}
