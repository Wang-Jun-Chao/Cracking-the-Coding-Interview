/**
 * 给定一幅由NxN 矩阵表示的图像，其中每个像素的大小为4字节， 编写一个方法，将
 * 图像旋转90度。不占用额外内存空间能否做到？
 * Author: 王俊超
 * Date: 2015-10-15
 * Time: 08:57
 * Declaration: All Rights Reserved !!!
 */
public class Solution {

    /**
     * 解法
     * 要将矩阵旋转90度，最简单的做法就是一层一层进行旋转。对每一层执行环状旋转（ circular
     * rotation ），将上边移到右边、右边移到下边、下边移到左边、左边移到上边。算法的时间复杂度为O(N^2），
     * 这已是最优的做法，因为任何算法都需要访问所有Ni个元素
     *
     * @param matrix
     * @param n
     */
    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - first;
                // 存储上边
                int top = matrix[first][i];
                // 左到上
                matrix[first][i] = matrix[last - offset][first];
                // 下到左
                matrix[last - offset][first] = matrix[last][last - offset];
                // 右到下
                matrix[last][last - offset] = matrix[i][last];
                // 上到右
                matrix[i][last] = top;
            }
        }
    }

    /**
     * 解法二：先将矩阵进行转迭，再对每一行进行翻转，效率不如第一种高
     *
     * @param matrix
     * @param n
     */
    public void rotate2(int[][] matrix, int n) {

    }
}
