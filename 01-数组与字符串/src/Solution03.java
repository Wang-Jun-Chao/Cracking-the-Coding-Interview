import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后．能否变成另
 * 一个字符串。
 * 跟其他许多问题一样， 首先我们应该向面试官确认一些细节，弄清楚变位词
 * （ anagram : 变位词是由变换某个词或短语的字母顺序而构成的新的词或短语）
 * 比较是否区分大小写。比如， God是否为dog的变位词？此外，我们还应该问清楚是否要考虑空白
 * 字符。这里假定变位词比较区分大小写，空白也要考虑在内。也就是说，“god ”不是“dog”的
 * 变位词。比较两个字符串时，只要两者长度不同，就不可能是变位词。解决这个问题有两个简单的解决方法，
 * 并且都采用了上述优化，即先比较字符串长度。
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 15:14
 * Declaration: All Rights Reserved !!!
 */
public class Solution03 {

    /**
     * 对字符串进行排序，并且返回排序后的字符串，假定输入的串不为空
     *
     * @param s
     * @return
     */
    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * 解法1 ：排序字符串
     * 若两个字符串互为变位词，那么它们拥有同一组字符，只不过顺序不同。因此，对字符串排
     * 序，组成这两个变位词的字符就会有相同的顺序。我们只需比较排序后的字符串。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation(String s, String t) {
        // 两个字符串都为空是返回true
        if (s == null && t == null) {
            return true;
        }

        // 只有一个为空时返回false，两个串都不为空，并且长度不相等
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // 下面是两个字符串长度相等的情况
        return sort(s).equals(sort(t));
    }

    /**
     * 解法2：检查两个字符串的各字符数是否相同，前提是输入的字符只是ASCII
     * 我们还可以充分利用变位词的定义一一组成两个单词的字符数相同一一来实现这个算法。我
     * 们只需遍历字母表，计算每个字符出现的次数。然后，比较这两个数组即可。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation2(String s, String t) {
        // 两个字符串都为空是返回true
        if (s == null && t == null) {
            return true;
        }

        // 只有一个为空时返回false，两个串都不为空，并且长度不相等
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // 下面是两个字符串长度相等的情况

        // 假设输入的字符是ASCII
        int[] letters = new int[256];
        // 统计s中字符的数目
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            letters[val]++;
        }

        // t中和字符如果可以和s中的字符完全抵消，就说明满足题意
        for (int i = 0; i < t.length(); i++) {
            int val = t.charAt(i);
            letters[val]--;
            if (letters[val] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 解法3：当输入的字符使用Unicode字符集时，我们使用HashMap来进行处理，类似于解法2
     *
     * @param s
     * @param t
     * @return
     */
    public boolean permutation3(String s, String t) {
        // 两个字符串都为空是返回true
        if (s == null && t == null) {
            return true;
        }

        // 只有一个为空时返回false，两个串都不为空，并且长度不相等
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // 下面是两个字符串长度相等的情况
        Map<Character, Integer> map = new HashMap<>(256);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字符已经出现过了就累加
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                // 第一次出现就设置为0
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            // 如果有这个与c相等的key
            if (map.containsKey(c)) {
                int num = map.get(c);
                // 只有一个了就删除
                if (num == 1) {
                    map.remove(c);
                } else {
                    // 计数值就减一
                    map.put(c, map.get(c) - 1);
                }

            } else {
                return false;
            }
        }

        return true;
    }
}
