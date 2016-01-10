import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-10 09:42
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Queens {
    public int nQueens(int n) {
        int sum = 0;

        // 棋盘，board[i]=j表示[i, board[i]=放置棋子
        int[] board = new int[n];

        for (int i = 0; i < board.length; i++) {
            board[i] = -1;
        }

        // 第i个棋子
        int i = 0;
        while (i >= 0) {
            board[i]++;
            while (board[i] < n && !check(board, i)) {
                board[i]++;
            }

            if (board[i] < n) {
                // 如果最后一个元素处理完了
                if (i == n - 1) {
                    sum++;
                } else {
                    // 处理下一个后
                    i++;
                    // 放在第一个位置
                    board[i] = -1;
                }
            } else {
                // 返回到上一个棋子
                i--;
            }
        }

        return sum;
    }

    /**
     * 检查第i个元素是否可以放元素
     *
     * @param board
     * @param k
     * @return
     */
    public boolean check(int[] board, int k) {
        for (int i = 0; i < k; i++) {
            if (Math.abs(k - i) == Math.abs(board[k] - board[i]) || board[i] == board[k]) {
                return false;
            }
        }

        return true;
    }
}
