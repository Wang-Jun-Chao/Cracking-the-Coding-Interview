import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-01-12 09:05
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Change {
    public int countChanges(String[] dic, int n, String startWord, String stopWord) {
        Queue<String> actionQueue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();
        Map<String, String> backtrackMap = new HashMap<>();

        Set<String> dictionary = new HashSet<>();
        Collections.addAll(dictionary, dic);

        List<String> list = new LinkedList<>();

        actionQueue.add(startWord);
        visitedSet.add(startWord);

        while (!actionQueue.isEmpty()) {
            String w = actionQueue.poll();
            // 获取所有的一次可编辑单词
            Set<String> editWords = getOneEditWords(w);

            for (String v : editWords) {
                // 已经找到了最后一个单词了
                if (v.equals(stopWord)) {

                    list.add(v);
                    while (w != null) {
                        list.add(0, w);
                        w = backtrackMap.get(w);
                    }

                    return list.size() - 1;
                }

                // v是字典中的单词
                System.out.println(v);
                if (dictionary.contains(v)) {
                    if (!visitedSet.contains(v)) {
                        actionQueue.add(v);
                        visitedSet.add(v);
                        backtrackMap.put(v, w);
                    }
                }
            }
        }


        return -1;
    }

    /**
     * 获取一个单词的所有一次变换后的单词，不包含自身，
     *
     * @param s 待编辑的单词
     * @return 词的所有一次变换后的单词集合
     */
    public Set<String> getOneEditWords(String s) {
        Set<String> words = new TreeSet<>();


        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                char c = (char) ('A' + j);
                // 处理大写
                if (c != s.charAt(i)) {
                    chars[i] = c;
                    words.add(new String(chars));
                }

                // 处理小写
                c = (char) ('a' + j);
                if (c != s.charAt(i)) {
                    chars[i] = c;
                    words.add(new String(chars));
                }
            }
        }

        return words;
    }
}
