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
        for (int i = 0; i < s.length() ; i++) {
            tree.insert(s, i);
        }



        return rs;
    }

    /**
     * 后缀树
     */
    public static class SuffixTree {

        Map<Character, Node> children = new HashMap<>();

        SuffixTree() {

        }

        public void insert(String s, int idx) {
            if (s == null || idx < 0 || idx >= s.length()) {
                return;
            }

            char c = s.charAt(idx);
            Node node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new Node();
                children.put(c, node);
            }

            node.insertString(s, idx);
        }

        public boolean contain(String s) {

            if (s == null || s.length() < 1) {
                return false;
            }

            char c = s.charAt(0);

            if (children.containsKey(c)) {
                return children.get(c).search(s, 0);
            }

            return false;
        }


        public static class Node {
            // 节点保存的值
            char value;
            // 子结点
            Map<Character, Node> children = new HashMap<>();
            // value出现在字符串中的位置
            List<Integer> indexes = new ArrayList<>();

            public Node() {
            }

            /**
             * 插入字符串
             *
             * @param s 待插入的字符串
             */
            public void insertString(String s, int idx) {

                if (s != null && s.length() > idx) {
                    value = s.charAt(idx);

                    idx++;
                    if (idx < s.length()) {
                        Node child;

                        if (children.containsKey(value)) {
                            child = children.get(value);
                        } else {
                            child = new Node();
                            children.put(value, child);
                        }
                        child.insertString(s, idx);
                    }

                }
            }

            public boolean search(String s, int idx) {
                if (s == null || s.length() == 0) {
                    return false;
                }

                if (idx >= s.length()) {
                    return true;
                }


                if (s.charAt(idx) == value) {
                    idx++;
                    if (children.containsKey(s.charAt(idx))) {
                        return children.get(s.charAt(idx)).search(s, idx);
                    }
                }


                return false;
            }
        }

//        public static class Node {
//            // 节点保存的值
//            char value;
//            // 子结点
//            Map<Character, Node> children = new HashMap<>();
//            // value出现在字符串中的位置
//            List<Integer> indexes = new ArrayList<>();
//
//            public Node() {
//            }
//
//            /**
//             * 插入字符串
//             *
//             * @param s   待插入的字符串
//             * @param idx
//             */
//            public void insertString(String s, int idx) {
//                indexes.add(idx);
//                if (s != null && s.length() >= 0) {
//                    value = s.charAt(0);
//                    Node child = null;
//
//                    if (children.containsKey(value)) {
//                        child = children.get(value);
//                    } else {
//                        child = new Node();
//                        children.put(value, child);
//                    }
//
//                    String reminder = s.substring(1);
//                    child.insertString(reminder, idx);
//                }
//            }
//
//            public List<Integer> search(String s) {
//                if (s == null || s.length() == 0) {
//                    return indexes;
//                } else {
//                    char first = s.charAt(0);
//                    if (children.containsKey(first)) {
//                        String remainder = s.substring(1);
//                        return children.get(first).search(remainder);
//                    }
//                }
//
//                return new ArrayList<>();
//            }
//        }
    }
}
