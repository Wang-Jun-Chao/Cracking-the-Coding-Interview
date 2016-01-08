import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2016-01-07 20:21
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Rank {
    public int[] getRankOfNumber(int[] A, int n) {
        // 所有元素小于等于待加入的元素
        List<Integer> le = new ArrayList<>();
        // 所有元素大于待加入的元素
        List<Integer> gt = new ArrayList<>();
        // 保存元素的秩
        int[] rs = new int[n];

        int v;
        for (int i = 0; i < n; i++) {

            int item = A[i];
            // 将gt中小于等于i的元素添加到le中
            while (!gt.isEmpty() && (v = gt.get(gt.size() - 1)) <= item) {
                // 删除最后一个
                gt.remove(gt.size() - 1);
                le.add(v);
            }

            // 将le中大于i的元素添加到gt中
            while (!le.isEmpty() && (v = le.get(le.size() - 1)) > item) {
                // 删除最后一个
                le.remove(le.size() - 1);
                gt.add(v);
            }

            // 保存元素的秩
            rs[i] = le.size();

            // 添加元素
            le.add(item);

        }

        return rs;
    }
}
