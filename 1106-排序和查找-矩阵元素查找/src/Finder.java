/**
 * Author: 王俊超
 * Date: 2016-01-07 20:05
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Finder {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        for (int i = 0; i < n;) {
            for (int j = m - 1; j >= 0;) {
                // 找到就返回
                if (mat[i][j] == x) {
                    return new int[]{i, j};
                }
                // 如果找到的元素比匹配的元素大，列数减少
                else if (mat[i][j] > x){
                    j--;
                }
                // 如果找到的元素比匹配的元素小，行数增大
                else {
                    i++;
                }
            }
        }

        return new int[]{-1, -1};
    }
}
