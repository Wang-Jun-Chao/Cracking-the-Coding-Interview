/**
 * Author: 王俊超
 * Date: 2016-01-07 21:51
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Max {
    public int getMax(int a, int b) {
        int d = a - b;
        // 若d为正，则e为0
        // 若d为负，则e为-1
        int e = d >> 31;

        return a + d * e;
    }
}
