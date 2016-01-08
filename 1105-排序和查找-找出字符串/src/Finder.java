/**
 * Author: 王俊超
 * Date: 2016-01-07 19:17
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Finder {
    public int findString(String[] str, int n, String x) {

        int lo = 0;
        int hi = n - 1;
        int mid;

        while (lo <= hi) {

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
            while (mid <= hi && str[mid].equals("")) {
                mid++;
            }

            if (str[mid].equals(x)) {
                return mid;
            } else if (str[mid].compareTo(x) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

//            mid = lo + (hi - lo) / 2;
//            // 如果是空字符串
//            if (str[mid].equals("")) {
//                int prev = mid - 1;
//                int next = mid + 1;
//
//                // 找空白符前第一个非空白符
//                while (prev > lo && str[prev].equals("")) {
//                    prev--;
//                }
//                // 找空白符后第一个非空白符
//                while (next < hi && str[next].equals("")) {
//                    next++;
//                }
//
//                if (prev == lo )
//
//                // 前一个小，后一个大，中间没有相等的，所以返回-1，找不到这个元素
//                if (str[prev].compareTo(x) < 0 && str[next].compareTo(x) > 0) {
//                    return -1;
//                } else if (str[prev].compareTo(x) > 0) {
//                    hi = prev - 1;
//                } else if (str[next].compareTo(x) < 0) {
//                    lo = next + 1;
//                } else {
//                    if (str[prev].compareTo(x) == 0) {
//                        return prev;
//                    } else {
//                        return next;
//                    }
//                }
//            }
//            // 非空字符串
//            else {
//                if (str[mid].equals(x)) {
//                    return mid;
//                }else if (str[mid].compareTo(x) < 0) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid - 1;
//                }
//            }
        }
        return -1;
    }
}
