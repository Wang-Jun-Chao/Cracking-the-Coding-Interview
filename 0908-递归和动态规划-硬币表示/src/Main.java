/**
 * Author: 王俊超
 * Date: 2016-01-07 15:18
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Coins c = new Coins();

        for (int i = 0; i < 30; i++) {
            System.out.println(i +": " + c.countWays(i) + "\n");
        }
    }
}
