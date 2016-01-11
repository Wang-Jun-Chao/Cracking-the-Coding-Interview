import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-11 14:27
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Result {
    public int[] calcResult(String A, String guess) {
        int[] rs = {0, 0};
        // 猜标记数组
        boolean[] hit = new boolean[A.length()];
        Map<Character, Integer> color = new HashMap<>();

        // 计算猜中的数
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = guess.charAt(i);

            // 猜中
            if (a == b) {
                rs[0]++;
                hit[i] = true;
            } else {
                if (color.containsKey(a)) {
                    color.put(a, color.get(a) + 1);
                } else {
                    color.put(a, 1);
                }
            }
        }


        for (int i = 0; i < guess.length(); i++) {
            // 未命中的
            if (!hit[i]) {
                char c = guess.charAt(i);
                if (color.containsKey(c)) {
                    rs[1]++;
                    if (color.get(c) > 1) {
                        color.put(c, color.get(c) - 1);
                    } else {
                        color.remove(c);
                    }
                }
            }
        }


        return rs;
    }
}
