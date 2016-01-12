import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2016-01-11 21:51
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] rs = new boolean[n];

        SuffixTree tree = new SuffixTree();
        for (int i = 0; i < s.length(); i++) {
            tree.insert(s, i);
        }

        for (int i = 0; i < p.length; i++) {
            rs[i] = tree.contain(p[i]);
        }

        return rs;
    }

    /**
     * 后缀树
     */
    public static class SuffixTree {

        // 树的第一层子结点
        Map<Character, Node> children = new HashMap<>();

        SuffixTree() {

        }

        /**
         * 向后缀树中插入一个字符串
         *
         * @param s   待插入的字符串
         * @param idx 待插入的第一个字符的位置
         */
        public void insert(String s, int idx) {
            // 如果字符串为空，或者已经到达字符串的末尾，就返回false
            if (s == null || idx < 0 || idx >= s.length()) {
                return;
            }

            // 取结点值
            char c = s.charAt(idx);
            Node node;

            // 如果已经存在这样的结点就将结点取出，否则创建新的结点
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new Node();
                children.put(c, node);
            }

            // 构造后缀树的一个分支
            node.insertString(s, idx);
        }

        /**
         * 在后缀树中找值为s的路径
         *
         * @param s
         * @return
         */
        public boolean contain(String s) {

            // 字符串没有值
            if (s == null || s.length() < 1) {
                return false;
            }
            // 取第一个值
            char c = s.charAt(0);

            // 值在子结点中
            if (children.containsKey(c)) {
                return children.get(c).search(s, 0);
            }

            return false;
        }


        public static class Node {
            // 当前节点保存的值
            char value;
            // 子结点
            Map<Character, Node> children = new HashMap<>();

            public Node() {
            }

            /**
             * 插入字符串
             *
             * @param s 待插入的字符串
             */
            public void insertString(String s, int idx) {

                // s有值，并且没有到达结尾
                if (s != null && s.length() > idx) {
                    // 设置当前结点的值
                    value = s.charAt(idx);

                    // 移动到下一个结点
                    idx++;
                    // 下一个位置还有值
                    if (idx < s.length()) {
                        Node child;
                        // 取下琴位置的值
                        char c = s.charAt(idx);

                        // 如果已经存在这样子的子结点就将其取出来，否则就创建新的结点
                        if (children.containsKey(c)) {
                            child = children.get(c);
                        } else {
                            child = new Node();
                            children.put(c, child);
                        }

                        // 构造子结点
                        child.insertString(s, idx);
                    }

                }
            }

            /**
             * 找后缀树中是否有值为s子串的路径，s子串的起始位置为idx
             *
             * @param s   待找的字符串
             * @param idx 子串的起始位置
             * @return
             */
            public boolean search(String s, int idx) {
                // s没有值
                if (s == null || s.length() == 0) {
                    return false;
                }

                // 已经到达字符串的终点
                if (idx >= s.length()) {
                    return true;
                }

                //没有到达字符串的终点
                // idx位置的值与当前结点的值相等
                if (s.charAt(idx) == value) {
                    // 移动到下一个位置
                    idx++;

                    // 到达字符串的末尾
                    if (idx >= s.length()) {
                        return true;
                    }

                    // 如果子符在字结点中，就对子结点进行处理
                    if (children.containsKey(s.charAt(idx))) {
                        return children.get(s.charAt(idx)).search(s, idx);
                    }
                }

                return false;
            }
        }
    }
}
