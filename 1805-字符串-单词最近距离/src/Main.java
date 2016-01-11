/**
 * Author: 王俊超
 * Date: 2016-01-11 20:56
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Distance d = new Distance();

        String[] arr = {"lab", "lab", "nhb", "nhb", "lab", "nhb", "nhb", "nhb", "lab"};
        System.out.println(d.getDistance(arr, arr.length, "nhb", "lab"));
    }
}
