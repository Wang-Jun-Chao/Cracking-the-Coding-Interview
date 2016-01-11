import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-11 21:03
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class LongestString {

    public int getLongest(String[] str, int n) {
        Map<String, Boolean> map = new HashMap<>();

        for (String s : str) {
            map.put(s, true);
        }

        // 先对字符串进行排序，按长度排序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (String s : str) {
            if (canBuildWord(s, true, map)) {
                return s.length();
            }
        }

        return 0;
    }

    /**
     * s是否可以由其它字符串拼接而成
     *
     * @param s
     * @param original 是否是最初的字符串
     * @param map
     * @return
     */
    private boolean canBuildWord(String s, boolean original, Map<String, Boolean> map) {

        // s在map中，并且s不是最初的字符串，即s是其它字符串被拆分出的
        if (map.containsKey(s) && !original) {
            return map.get(s);
        }

        // 将字符串分割成两个部分
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            // 左边部分在map中，并且左边部分是原始串
            // 右边部分也可以在通过map中的原始串拼接而成
            if (map.containsKey(left) && map.get(left) && canBuildWord(right, false, map)) {
                return true;
            }

        }

        // s不是原始串
        map.put(s, false);

        return false;
    }

    // 算法超时
    public int getLongest2(String[] str, int n) {
        // 先对字符串进行排序，按长度排序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Set<String> set = new HashSet<>(n);
        Collections.addAll(set, str);

        StringBuilder builder = new StringBuilder();

        int[] rs = {0};
        getLongest(str, set, builder, rs);
        return rs[0];
    }

    private void getLongest(String[] str, Set<String> set,
                            StringBuilder builder, int[] rs) {
        // 如果已经达到了最长的字符的长度
        if (builder.length() >= str[str.length - 1].length()) {
            return;
        }

        for (String s : str) {
            // 拼接字符串
            builder.append(s);

            // 如果字符在set中，并且长度比较记录到的长度长，就更新最大长度
            if (set.contains(builder.toString()) && builder.length() > rs[0]) {
                rs[0] = builder.length();
            }

            // 递归求解
            getLongest(str, set, builder, rs);

            // 设置新的长度（其实就是现场还原）
            builder.setLength(builder.length() - s.length());
        }
    }
}
