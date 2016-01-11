/**
 * Author: 王俊超
 * Date: 2016-01-11 09:28
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Joseph {
    public int getResult(int n, int m) {
        if (n <= 1 || m <= 1) {
            return 0;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }

        return last + 1;
    }
}
