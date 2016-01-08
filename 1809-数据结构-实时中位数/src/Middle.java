import java.util.TreeSet;

/**
 * Author: 王俊超
 * Date: 2016-01-08 15:28
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Middle {
    public int[] getMiddle(int[] A, int n) {
        // 放前一半的数，
        TreeSet<Integer> prev = new TreeSet<>();
        // 放后一半的数
        TreeSet<Integer> next = new TreeSet<>();

        int[] rs = new int[n];

        for (int i = 0; i < n; i++) {
            // 如果是第奇数个数，其下标为偶数，数字应该放入前半部分
            if (i % 2 == 0) {
                // 要插入的数据比后半部分的最小的一个大
                // 需要将后半部分的最小的元素移除掉，放入前半部分，A[i]放入后半部分
                if (!next.isEmpty() && next.first() < A[i]) {

                    prev.add(next.first());
                    next.remove(next.first());
                    next.add(A[i]);
                } else {
                    prev.add(A[i]);
                }

            }
            // 如果是第数数个数，其下标为奇数，数字添加到后半部分
            else {
                // 要插入的数据比前半部分的最大的一个小
                // 需要将前半部分的最大的元素移除掉，放入后半部分，A[i]放入后前部分
                if (prev.last() > A[i]) {
                    next.add(prev.last());
                    prev.remove(prev.last());
                    prev.add(A[i]);
                } else {
                    next.add(A[i]);
                }

            }

            // 中伴数在前半部分的最后一个
            rs[i] = prev.last();
        }

        return rs;
    }
}
