/**
 * Author: 王俊超
 * Date: 2016-01-07 21:42
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Board {
    public boolean checkWon(int[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 3) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] + board[1][i] + board[2][i] == 3) {
                return true;
            }
        }

        if (board[0][0] + board[1][1] + board[2][2] == 3) {
            return true;
        }


        return board[0][2] + board[1][1] + board[2][0] == 3;
    }
}
