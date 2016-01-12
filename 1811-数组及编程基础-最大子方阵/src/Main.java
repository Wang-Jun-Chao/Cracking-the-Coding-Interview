/**
 * Author: 王俊超
 * Date: 2016-01-12 11:19
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SubMatrix sb = new SubMatrix();

        System.out.println(sb.maxSubMatrix(mat, mat.length));

        mat = new int[][]{{0, 1, 0, 0}, {1, 0, 0, 0}, {0, 0, 1, 1}, {0, 1, 0, 1}};
        System.out.println(sb.maxSubMatrix(mat, mat.length));
    }
}
