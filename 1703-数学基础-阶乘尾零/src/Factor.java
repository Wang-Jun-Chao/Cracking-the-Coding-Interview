/**
 * Author: 王俊超
 * Date: 2016-01-07 22:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Factor {
    public int getFactorSuffixZero(int n) {

        int result = 0;
        while ((n = n / 5) != 0) {
            result += n;
        }

        return result;
    }
}
