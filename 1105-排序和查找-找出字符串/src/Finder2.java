/**
 * Author: 王俊超
 * Date: 2016-01-07 19:17
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Finder2 {

//    public static void main(String[] args) {
//        String[] str = {"a", "b", "", "c", "", "d"};
//        Finder main = new Finder();
//        System.out.println(main.findString(str, str.length, "c"));
//    }

    public int findString(String[] str, int n, String x) {

        if (str == null || str.length < 1) {
            return -1;
        }

        int lo = 0;
        int hi = n - 1;
        int mid;

        do {
            // 从lo位置开始向右找第一个非空字符
            while (lo <= hi && str[lo].equals("")) {
                lo++;
            }

            // 从hi位置开始向左找第一个非空字符
            while (lo <= hi && str[hi].equals("")) {
                hi--;
            }

            if (lo > hi) {
                return -1;
            }

            mid = lo + (hi - lo) / 2;

            // 找中间靠左边的第一个非空字符
            while (mid >= lo && str[mid].equals("")) {
                mid--;
            }

            if (str[mid].equals(x)) {
                return mid;
            } else if (str[mid].compareTo(x) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }


        } while (lo <= hi);

        return -1;
    }
}
