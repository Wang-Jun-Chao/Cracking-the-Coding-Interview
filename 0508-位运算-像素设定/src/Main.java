import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-09 14:36
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Render r = new Render();
        int[] ints = {0, 0, 0, 0, 0, 0};

        System.out.println(Arrays.toString(r.renderPixel(ints, 0, 47)));
    }
}
