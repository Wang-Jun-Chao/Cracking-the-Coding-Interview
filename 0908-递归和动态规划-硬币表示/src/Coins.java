/**
 * Author: 王俊超
 * Date: 2016-01-07 15:18
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Coins {

    public int countWays(int n) {
        int[] coin = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int a : coin) {
            // 内层循环第执行一次表示多选择一种有硬币有多少种解法
            for (int j = a; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - a]) % 1000000007;
            }
        }

        return dp[n];
    }

    // 算法的时间复杂度比较大
    public int countWays2(int n) {

        if (n < 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i <= n; i += 25) {
            for (int j = 0; j <= n - i; j += 10) {
                for (int k = 0; k <= n - i - j; k += 5) {
                    result = (++result) % 1000000007;
                }
            }
        }

        return result;

    }
}
