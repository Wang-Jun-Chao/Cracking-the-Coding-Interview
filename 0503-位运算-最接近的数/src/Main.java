import java.util.Random;

/**
 * Author: 王俊超
 * Date: 2016-01-07 14:15
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        CloseNumber cn = new CloseNumber();

//        Random r = new Random();
//        for (int i = 0; i < 20; i++) {
//            int v = r.nextInt(99998) + 2;
//            int[] rs = cn.getCloseNumber(v);
//            System.out.println(v + ": " + rs[0] + ", " + rs[1]);
//            System.out.println(Integer.toBinaryString(v));
//            System.out.println(Integer.toBinaryString(rs[0]));
//            System.out.println(Integer.toBinaryString(rs[1]));
//        }


        int[] rs = cn.getCloseNumber(76351);
        System.out.println(76351 + ": " + rs[0] + ", " + rs[1]);
        System.out.println(Integer.toBinaryString(76351));
        System.out.println(Integer.toBinaryString(rs[0]));
        System.out.println(Integer.toBinaryString(rs[1]));
    }
}
