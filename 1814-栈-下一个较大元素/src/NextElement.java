import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-08 13:37
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class NextElement {
    public int[] findNext(int[] A, int n) {
        int[] rs = new int[n];

        List<Integer> list = new ArrayList<>(n);


        for (int i = n - 1; i >= 0 ; i--) {
            int r = -1;
            for (int j = list.size() - 1; j >= 0 ; j--) {
                int  v = list.get(j);
                if (v > A[i]){
                    r = v;
                    break;
                }
            }

            list.add(A[i]);
            rs[i] = r;
        }

        return rs;
    }
}
