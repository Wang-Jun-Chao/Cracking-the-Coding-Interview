import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: 王俊超
 * Date: 2016-01-11 14:10
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Stack {
    public int getHeight(int[][] actors, int n) {
        int max = 1;

        int[] het = new int[n];
        het[0] = 1;

        // 先对身高进行排序
        Arrays.sort(actors, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 然后对体重按叠罗汉I问题进行处理
        for (int i = 1; i < n; i++) {
            het[i] = 1;
            for (int j = 0; j < i; j++) {
                if (actors[j][1] < actors[i][1] && het[i] <= het[j]) {
                    het[i] = het[j] + 1;
                }
            }

            if (het[i] > max) {
                max = het[i];
            }
        }

        return max;
    }
}
