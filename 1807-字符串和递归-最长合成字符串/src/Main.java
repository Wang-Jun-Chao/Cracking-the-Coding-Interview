/**
 * Author: 王俊超
 * Date: 2016-01-11 21:14
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        LongestString ls = new LongestString();

        String[] ss = {"a", "b", "c", "ab", "bc", "abc"};

        System.out.println(ls.getLongest(ss, ss.length));
    }
}
