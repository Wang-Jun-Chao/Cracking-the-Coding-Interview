/**
 * Author: 王俊超
 * Date: 2016-01-11 20:48
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Distance {
    public int getDistance(String[] article, int n, String x, String y) {
        int min = Integer.MAX_VALUE;
        // 记下x最后出现的位置
        int i = -1;
        // 记录y最后出现的位置
        int j = -1;

        for (int k = 0; k < article.length; k++) {
            String z = article[k];

            if (x.equals(z)) {
                i = k;
                int d = i - j;
                if (j >= 0 && min > d) {
                    min = d;
                }
            } else if (y.equals(z)) {
                j = k;
                int d = j - i;
                if (i >= 0 && min > d) {
                    min = d;
                }
            }
        }

        return min;
    }
}
