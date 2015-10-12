/**
 * 问题：实现一个算法，确定一个字符串的所高字符是否全都不罔。假使不允许使用额外的数 据结构，又该如何处理？
 * 假定字符集为ASCII，对于这个问题，我们可以做一个简单的优化，若字符串的长度大于字
 * 母表中的字符个数，则直接返回false 。毕竟，若字母表只有256个字符． 字符串里就不可能有280
 * 个各不相同的字符。
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 14:45
 * Declaration: All Rights Reserved !!!
 */
public class Solution01 {

    /**
     * 下面的代码假定字符串只含有小写字母a到z。这样一来．我们只需使用一个int型变量。
     *
     * @param str
     * @return
     */
    public boolean isUniqueChars(String str) {
        // 如果字符串为空认为不含重复的字符
        if (str == null) {
            return true;
        }

        // 长度大于256就一定有重复的
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // 求字母的序号，从0开始
            int val = str.charAt(i) - 'a';
            // 如果第val个字母已经出现过返回false
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                // 标记第val个数字已经出现了
                checker |= (1 << val);
            }
        }

        return true;
    }

    /**
     * 第一种解法是构建一个布尔值的数组，索引值1对应的标记指示该字符串是否含有字母表第i
     * 个字符。若这个字符第二次出现，则立即返回false 。
     * 使用位向量（ bit vector ），可以将空间占用减少为原先的1/8 。
     *
     * @param str
     * @return
     */
    public boolean isUniqueChars2(String str) {

        // 如果字符串为空认为不含重复的字符
        if (str == null) {
            return true;
        }

        // 长度大于256就一定有重复的
        if (str.length() > 256) {
            return false;
        }

        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            // 如果之前已经出现过该字符，就返回false
            if (charSet[val]) {
                return false;
            } else {
                // 标记字符已经出现过
                charSet[val] = true;
            }
        }

        // 没有出现过重复的字符
        return true;
    }
    /**
     * 其它的解法：
     * (1）将字符串中的每一个字符与其余字符进行比较。这种方法的时间复杂度为O（n^2）， 空间复
     * 杂度为0（1）。
     * (2）若允许修改输入字符串，可以在O(n Iog(n））时间里对字符串排序，然后线性检查其中有无
     * 相邻字符完全相同的情况。不过，值得注意的是， 很多排序算法会占用额外的空间。
     */
}
