import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-08 15:13
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        NextElement ne = new NextElement();
        int[] ints = {11, 13, 10, 5, 12, 21, 3};
        System.out.println(Arrays.toString(ne.findNext(ints, ints.length)));
    }
}
