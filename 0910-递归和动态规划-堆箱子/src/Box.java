import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-10 11:07
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Box {
    public int getHeight(int[] w, int[] l, int[] h, int n) {

        int[] dp = new int[n];
        int max = 0;

        List<Cube> list = new ArrayList<>(n);
        for (int i = 0; i < w.length; i++) {
            list.add(new Cube(l[i], w[i], h[i]));
        }

        Collections.sort(list, new Comparator<Cube>() {
            @Override
            public int compare(Cube o1, Cube o2) {

                if (o1.length != o2.length) {
                    return o1.length - o2.length;
                }

                if (o1.width != o2.width) {
                    return o1.width - o2.width;
                }

                return o1.height - o2.height;
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = list.get(i).height;
            for (int j = 0; j < i; j++) {
                if (compare(list.get(i), list.get(j)) &&
                        dp[i] < list.get(i).height + dp[j]) {
                    dp[i] = dp[j] + list.get(i).height;
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }

        return max;

    }

    /**
     * 方块c1长宽是是否比c2大
     *
     * @param c1
     * @param c2
     * @return
     */
    public boolean compare(Cube c1, Cube c2) {
        if (c1.length > c2.length && c1.width > c2.width) {
            return true;
        }

        return false;
    }

    public static class Cube {
        private int length;
        private int width;
        private int height;

        public Cube(int l, int w, int h) {
            this.length = l;
            this.width = w;
            this.height = h;
        }
    }

}
