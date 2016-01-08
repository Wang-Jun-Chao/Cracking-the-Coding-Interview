/**
 * Author: 王俊超
 * Date: 2016-01-07 22:18
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        MaxSum ms = new MaxSum();
        int[] is1 = {1, 2, 3, -6, 1};
        int[] is2 = {1, 2, 3, -6, 1, 7};

        System.out.println(ms.getMaxSum(is1, is1.length));
        System.out.println(ms.getMaxSum(is2, is2.length));
    }
}
