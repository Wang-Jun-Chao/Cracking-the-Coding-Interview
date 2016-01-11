import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-11 15:21
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Result r = new Result();
        System.out.println(Arrays.toString(r.calcResult("RGBY", "GGRR")));
        System.out.println(Arrays.toString(r.calcResult("YGBG", "YRYG")));
        System.out.println(Arrays.toString(r.calcResult("BGGB", "GGRR")));
        System.out.println(Arrays.toString(r.calcResult("RBBY", "BRGB")));
    }
}
