/**
 * Author: 王俊超
 * Date: 2016-01-11 16:12
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Rearrange {
    public int[] findSegment(int[] A, int n) {
        int[] rs = {0, 0};

        // 找数组左边严格递增序列的最后一个值的下标
        int endLeft = findEndOfLeft(A);
        // 找数组右边严格递增序列的第一个值的下标
        int startRight = findStartOfRight(A);

        // 下面开始找出中间部分的最小位和最大值

        int midIdx = endLeft + 1;

        // 已经排好序了
        if (midIdx >= A.length) {
            return rs;
        }
        int maxIdx = startRight - 1;
        for (int i = endLeft; i <= startRight; i++) {
            if (A[i] < A[midIdx]) {
                midIdx = i;
            }

            if (A[i] > A[maxIdx]) {
                maxIdx = i;
            }
        }

        rs[0] = getLeft(A, endLeft, midIdx);
        rs[1] = getRight(A, startRight, maxIdx);

        return rs;
    }

    /**
     * 找数组左边严格递增序列的最后一个值的下标
     *
     * @param arr
     * @return
     */
    public int findEndOfLeft(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }

        return arr.length - 1;
    }

    /**
     * 找数组右边严格递增序列的第一个值的下标
     *
     * @param arr
     * @return
     */
    public int findStartOfRight(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    /**
     * 在[0, start]中从右向左找，找第一个小于等于maxIdx位置的值的元素的下标
     *
     * @param arr
     * @param start
     * @param maxIdx
     * @return
     */
    public int getLeft(int[] arr, int start, int maxIdx) {
        for (int i = start; i >= 0; i--) {
            if (arr[i] <= arr[maxIdx]) {
                return i + 1;
            }
        }

        return 0;
    }

    /**
     * 在[start, arr.length-1]中从左向和右找，找第一个大于于等于maxIdx位置的值的元素的下标
     *
     * @param arr
     * @param start
     * @param maxIdx
     * @return
     */
    public int getRight(int[] arr, int start, int maxIdx) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] >= arr[maxIdx]) {
                return i - 1;
            }
        }

        return arr.length - 1;
    }
}
