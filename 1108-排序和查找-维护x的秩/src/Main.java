import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-07 20:34
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Rank r = new Rank();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 1, -1};

        System.out.println(Arrays.toString(r.getRankOfNumber(ints, ints.length)));
    }
}
