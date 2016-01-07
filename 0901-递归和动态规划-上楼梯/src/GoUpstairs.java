/**
 * Author: 王俊超
 * Date: 2016-01-07 14:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class GoUpstairs {

    public int countWays2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;

        } else if (n == 3) {
            return 4;
        } else {
            return ((countWays2(n - 1) + countWays2(n - 2)) % 1000000007
                    + countWays2(n - 3)) % 1000000007;
        }
    }

    public int countWays(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        int result = 0;

        for (int i = 4; i <= n; i++) {
            result = ((n1 + n2) % 1000000007 + n3) % 1000000007;

            n1 = n2;
            n2 = n3;
            n3 = result;

        }


        return result;
    }
}
