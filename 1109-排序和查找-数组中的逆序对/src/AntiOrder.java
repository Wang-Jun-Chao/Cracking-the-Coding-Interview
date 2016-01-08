/**
 * Author: 王俊超
 * Date: 2016-01-07 20:37
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class AntiOrder {
    public int count(int[] A, int n) {
        int[] B = new int[n];
        System.arraycopy(A, 0, B, 0, n);
        return inversePairs(A, B, 0, n - 1);

    }

    private int inversePairs(int[] data, int[] copy, int beg, int end) {

        if (beg == end) {
            copy[beg] = data[beg];
            return 0;
        }

        int len = (end - beg) / 2;
        // 左边部分的逆序数
        int left = inversePairs(copy, data, beg, beg + len);
        // 右边部分的逆序数
        int right = inversePairs(copy, data, beg + len + 1, end);

        // 前半段的最后一个数字的下标
        int i = beg + len;
        // 后半段最后一个数字的下标
        int j = end;
        // 开始拷贝的位置
        int idx = end;
        // 逆序数
        int cnt = 0;

        // 进行拷贝操作
        while (i >= beg && j >= beg + len + 1) {
            if (data[i] > data[j]) {
                copy[idx] = data[i];
                idx--;
                i--;
                // 逆序数
                cnt += j - (beg + len);
            } else {
                copy[idx] = data[j];
                idx--;
                j--;
            }
        }

        for (; i >= beg;) {
            copy[idx] = data[i];
            idx--;
            i--;
        }

        for (;j >= beg + len + 1;) {
            copy[idx] = data[j];
            idx--;
            j--;
        }

        return cnt + left + right;
    }
}
