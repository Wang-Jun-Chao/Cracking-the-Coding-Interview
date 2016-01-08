/**
 * Author: 王俊超
 * Date: 2016-01-07 21:02
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        AntiOrder ao = new AntiOrder();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(ao.count(ints, ints.length));
    }
}
