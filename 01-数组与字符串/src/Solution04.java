/**
 * 编写一个算法，将字符串申的空格全部替换为“%20”。假定该字符串尾部有足够的
 * 空间存储新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组
 * 实现，以便直接在数组上操作。）
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 15:50
 * Declaration: All Rights Reserved !!!
 */
public class Solution04 {
    /**
     * 解法
     * 处理字符串操作问题时，常见做法是从字符串尾部开始编辑，从后往前反向操作。这种做法
     * 很有用，因为字符串尾部有额外的缓冲，可以直接修改，不必担心会覆写原有数据。
     * 我们将采用上面这种做法。该算法会进行两次扫描。第一次扫描先数出字符串巾有多少空格，
     * 从而算出最终的字符串有多长。第二次扫描才真正开始反向编辑字符串。检测到空格则将%20复
     * 制到下一个位置，若不是空白，就复制原先的字符。
     *
     * @param str    待替换的字符串
     * @param length 从第一个位置开始，连接存放的字符个数
     * @return 替换后的字符数组的长度
     */
    public int replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        int newLength = 0;

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + 2 * spaceCount;
        spaceCount = newLength - 1;
        for (int i = length - 1; i >= 0; i++) {
            if (str[i] == ' ') {
                str[spaceCount] = '0';
                str[spaceCount - 1] = '2';
                str[spaceCount - 2] = '%';
                spaceCount -= 3;
            } else {
                str[spaceCount] = str[i];
                spaceCount--;
            }
        }

        return newLength;
    }
}
