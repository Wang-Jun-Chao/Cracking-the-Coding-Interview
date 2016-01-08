import java.util.TreeSet;

/**
 * Author: 王俊超
 * Date: 2016-01-08 15:13
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class NextElement {
    public int[] findNext(int[] A, int n) {
        int[] rs = new int[n];

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = n - 1; i >= 0; i--) {
            Integer h = set.higher(A[i]);
            if (h == null) {
                rs[i] = -1;
            } else {
                rs[i] = h;
            }

            set.add(A[i]);
        }

        return rs;
    }
}
