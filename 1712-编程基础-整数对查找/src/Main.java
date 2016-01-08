import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-07 22:31
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        FindPair fp = new FindPair();
        int[] ints = {1, 2, 3, 4, 5};

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + ": " + fp.countPairs(ints, ints.length, i));
        }

        int[] ints2 = {11, 7, 7, 6, 14, 2, 14, 15, 2, 1, 2, 12, 13, 9, 8, 15, 13, 8, 10, 11, 14,
                10, 2, 9, 4, 9, 3, 7, 6, 10, 15, 4, 7, 6, 15, 3, 9, 13, 5, 2, 6, 10, 10, 1, 12,
                4, 3, 3, 8, 8, 1, 4, 7, 11, 13, 5, 13, 15, 4, 3, 1, 11, 6, 11, 9, 9, 11, 15, 12,
                10, 13, 3, 11, 4, 8, 9, 7, 3, 13, 9, 11, 3, 2, 11, 10, 1, 4, 2, 3, 3, 14, 11, 5,
                10, 1, 14, 8, 1, 11, 3, 1, 9, 14, 6, 1, 7, 15, 10, 14, 6, 4, 12, 11};

        int rs = (fp.countPairs(ints2, ints2.length, 16));
        System.out.println(Arrays.toString(ints2));
        System.out.println(rs);
    }
}
