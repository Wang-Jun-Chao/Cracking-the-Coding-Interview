import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-11 13:32
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Stack {
    /**
     * <pre>
     * 源问题等价于求数组的最长递增子序列
     * 假设数组是v
     * 假设dp[i]表示以v[i]为最后一个元素的最长递增子序列的长度
     * 则有
     *      dp[i] = 1 (i=0)
     *      dp[i] = max{dp[j] + 1} (v[i] > v[j] && dp) or 1(v[i]是[0...i]最小的元素)
     * </pre>
     *
     * @param men
     * @param n
     * @return
     */
    public int getHeight(int[] men, int n) {
        int[] het = new int[n];


        int max = 1;
        het[0] = 1;

        for (int i = 1; i < n; i++) {
            het[i] = 1;
            for (int j = 0; j < i; j++) {
                if (men[j] < men[i] && het[i] <= het[j]) {
                    het[i] = het[j] + 1;
                }
            }

            if (het[i] > max) {
                max = het[i];
            }
        }


//        System.out.println(Arrays.toString(het));

        return max;
    }
}
