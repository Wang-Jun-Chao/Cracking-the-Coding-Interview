/**
 * Author: 王俊超
 * Date: 2016-01-09 14:59
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class AddSubstitution {
    public int calc(int a, int b, int type) {
        int rs = 0;
        switch (type) {
            case 1:
                break;
            case 0:
                break;
            case -1:
                break;
        }

        return rs;
    }

    /**
     * 求一个数据的相反数，按位取反，末位加一
     *
     * @param n
     * @return
     */
    public int negate(int n) {
        return (~n) + 1;
    }


    /**
     * 两数相减相当于对b取反， 然后将两数相加
     *
     * @param a
     * @param b
     * @return
     */
    public int minus(int a, int b) {
        return a + negate(b);
    }

    public int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);
        }

        int sum = 0;
        for (int i = Math.abs(b); i > 0; i--) {
            sum += a;
        }

        if (b < 0) {
            sum = negate(sum);
        }

        return sum;
    }
}
