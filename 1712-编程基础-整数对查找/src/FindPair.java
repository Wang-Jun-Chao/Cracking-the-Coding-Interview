import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-07 22:29
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class FindPair {
    public int countPairs(int[] A, int n, int sum) {
        int rs = 0;

        Arrays.sort(A);

        return countPairs(A, 0, A.length - 1, sum);

//        int lo = 0;
//        int hi = n - 1;
//
//        while (lo < hi) {
//            if (A[lo] + A[hi] == sum) {
//                rs++;
//                lo++;
//                hi--;
//            } else if (A[lo] + A[hi] < sum) {
//                lo++;
//            } else {
//                hi--;
//            }
//        }
//
//        return rs;
    }

    public int countPairs(int[] A, int beg, int end, int sum) {
        int rs = 0;
        int lo = beg;
        int hi = end;

        while (lo < hi) {
            if (A[lo] + A[hi] == sum) {
                int i = lo;
                while (i < hi && A[lo] == A[i]) {
                    i++;
                }
                int j = hi;
                while (i <= j && A[j] == A[hi]) {
                    j--;
                }

                rs += (i - lo) * (hi - j);
                lo = i;
                hi = j;

            } else if (A[lo] + A[hi] < sum) {
                lo++;
            } else {
                hi--;
            }
        }

        return rs;
    }
}
