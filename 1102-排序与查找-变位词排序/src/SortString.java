import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-07 18:59
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class SortString {
    public ArrayList<String> sortStrings(String[] str, int n) {
        ArrayList<String> list = new ArrayList<>();

        Map<Integer, String> map = new HashMap<>(str.length);


        for (String s : str) {
            int hashCode = getKey(s);
            String t = map.get(hashCode);

            // 如果不在就添加
            if (t == null) {
                map.put(hashCode, s);
            }
            // 存在
            else {
                // 新添加的值比来的小
                if (s.compareTo(t) < 0) {
                    map.put(hashCode, s);
                }
            }
        }

        for (String s : map.values()) {
            list.add(s);
        }

        // 排序
        Collections.sort(list);
        return list;
    }

    // 计算hashCode
    public int getKey(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars).hashCode();
    }
}
