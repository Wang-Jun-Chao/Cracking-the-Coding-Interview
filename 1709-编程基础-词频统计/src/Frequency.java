import java.util.HashMap;
import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2016-01-07 22:25
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Frequency {
    public int getFrequency(String[] article, int n, String word) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : article) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        if (map.containsKey(word)) {
            return map.get(word);
        } else {
            return 0;
        }
    }
}
