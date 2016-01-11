/**
 * Author: 王俊超
 * Date: 2016-01-11 09:46
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Joseph j = new Joseph();
        System.out.println(j.getResult(385,248));
        System.out.println(j.getResult(5, 3)); // 最后余下4
        System.out.println(j.getResult(5, 2)); // 最后余下3
        System.out.println(j.getResult(6, 7)); // 最后余下5
        System.out.println(j.getResult(6, 6)); // 最后余下4
        System.out.println(j.getResult(0, 0)); // 最后余下0
        System.out.println(j.getResult(1, 1)); // 最后余下0
        System.out.println(j.getResult(2, 2)); // 最后余下1
    }
}
