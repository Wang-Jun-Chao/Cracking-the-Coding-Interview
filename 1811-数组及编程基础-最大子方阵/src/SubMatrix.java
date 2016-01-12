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
            boolean bool = findSquareWithSize(mat, i, 0)
                    || findSquareWithSize(mat, i, 1);
            if (bool) {
                return i;
            }
        }

        return 0;
    }

    public boolean findSquareWithSize(int[][] mat, int size, int type) {
        int count = mat.length - size + 1;
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(mat, row, col, size, type)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isSquare(int[][] mat, int row, int col, int size, int type) {
        for (int i = 0; i < size; i++) {
            if (mat[row][col + i] == type) {
                return false;
            }

            if (mat[row + size - 1][col + i] == type) {
                return false;
            }
        }

        for (int i = 1; i < size; i++) {
            if (mat[row + i][col] == type) {
                return false;
            }

            if (mat[row + i][col + size - 1] == type) {
                return false;
            }
        }

        return true;
    }
}
