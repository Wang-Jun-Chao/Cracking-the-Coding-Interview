/**
 * Author: 王俊超
 * Date: 2016-01-09 14:59
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class AddSubstitution {
    public int calc(int a, int b, int type) {

        switch (type) {
            case 1:
                return multiply(a, b);
            case 0:
                return divide(a, b);

            case -1:
                return minus(a, b);
        }

        return 0;
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

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("divide by zero");
        }

        int absa = Math.abs(a);
        int absb = Math.abs(b);

        int p = 0;
        int x = 0;
        while (p + absb <= absa) {
            p += absb;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }
}
