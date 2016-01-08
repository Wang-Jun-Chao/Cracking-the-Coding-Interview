import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-08 15:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Middle m = new Middle();
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(m.getMiddle(ints, ints.length)));
    }
}
