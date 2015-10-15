/**
 * 利用字符重复出现的灰数，编写一个万法，实现基本本的字符串压缩归能。比如，字符
 * 串aabcccccaaa 会变为a2blc5a3o 若“压缩”后的字符串没青变短，则返回原先的字符串。
 * Author: 王俊超
 * Date: 2015-10-15
 * Time: 08:02
 * Declaration: All Rights Reserved !!!
 */
public class Solution05 {

    /**
     * 这段代码并未处理压缩后字符串比原始字符串长的情况，但除此之外，全都满足要求。
     * 这段代码的执行时间为O(p+k^2)。其中p为原始字符串长度. k为字符序列的数量。比如，若
     * 字符串为aabccdeeaa ，则总计有6个字符序列。执行速度慢的原因是字符串拼接操作的时间复杂
     * 度为O(n^2)
     *
     * @param str
     * @return
     */
    public String compressBad(String str) {
        // 如果字符串为null或者长度小于等于2返回原来的字符串
        if (str == null || str.length() <= 2) {
            return str;
        }

        String mystr = "";
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            // 找到重复的字符
            if (str.charAt(i) == last) {
                count++;
            } else {
                // 如果不重复就把新统计到的字符重复数接到结果字符字符串后面
                mystr += last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }

        return mystr + last + count;
    }

    /**
     * 使用StringBuilder进行性能优化
     *
     * @param str
     * @return
     */
    public String compressBetter(String str) {
        // 检查压缩后字符串是否会变量更长
        int size = countCompress(str);
        if (size >= str.length()) {
            return str;
        }

        StringBuilder builder = new StringBuilder(str.length());
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            // 找到重复的字符
            if (str.charAt(i) == last) {
                count++;
            } else {
                // 插入字符的数目，更新last字符
                // 插入字符
                builder.append(last);
                // 插入数目
                builder.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        // 添加最后一级字符的个数
        builder.append(last);
        builder.append(count);
        return builder.toString();
    }

    /**
     * 计算压缩后的字符数
     *
     * @param str
     * @return
     */
    private int countCompress(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            // 找到重复的字符
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }

        size += 1 + String.valueOf(count).length();
        return size;
    }

    public String compressButter2(String str) {

        if (str == null || str.length() <= 2) {
            return str;
        }

        StringBuilder builder = new StringBuilder(str.length());
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            // 找到重复的字符
            if (str.charAt(i) == last) {
                count++;
            } else {
                // 插入字符的数目，更新last字符
                // 插入字符
                builder.append(last);
                // 插入数目
                builder.append(count);
                last = str.charAt(i);
                count = 1;

                // 如果builder的字符数比str中的还要长，就说明压缩后会变得更长，
                // 返回原来的字符串
                if (builder.length() >= str.length()) {
                    return str;
                }
            }
        }

        // 添加最后一级字符的个数
        builder.append(last);
        builder.append(count);
        return builder.toString();
    }

    /**
     * 不使用字符串相关的类来实现
     *
     * @param str
     * @return
     */
    public String compressAlternate(String str) {
        // 检查压缩后字符串是否会变量更长
        int size = countCompress(str);
        if (size >= str.length()) {
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            // 找到重复的字符
            if (str.charAt(i) == last) {
                count++;
            } else {
                // 更新重复字符的数目
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }
        // 更新最后一个重复字符的数目
        index = setChar(array, last, index, count);
        return String.valueOf(array);
    }

    private int setChar(char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        char[] cnt = String.valueOf(count).toCharArray();

        for (char x : cnt) {
            array[index] = x;
            index++;
        }

        return index;
    }


}
