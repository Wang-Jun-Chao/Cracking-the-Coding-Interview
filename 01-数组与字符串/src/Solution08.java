/**
 * 假定有一个方法isSubstring，可检查一个单词是否为其他字待串的子串。给定两个
 * 字符串s1和s2，请编写代码检查s2是否为s1旋转而成， 要求只能调用一次isSubstring。（比
 * 如， waterbottle 是erbottlewat 旋转后的字符串。）
 * Author: 王俊超
 * Date: 2015-10-16
 * Time: 14:21
 * Declaration: All Rights Reserved !!!
 */
public class Solution08 {

    /**
     * 解法
     * 假定s2 由s l旋转而成，那么，我们可以找出旋转点在哪。例如，若以wat对waterbottle旋
     * 转，就会得到erbottlewat 。在旋转字符串时，我们会把sl切分为两部分：x和y，并将它们重新
     * 重新组合成s2 。
     * sl = xy = waterbottle
     * x = wat
     * y = erbottle
     * s2 = yx = erbottlewat
     * 因此，我们需要确认有没有办法将s1切分为x和y ，以满足xy = s1和yx = s2 。不论x和y之
     * 间的分割点在何处，我们会发现yx肯定是xyxy的子串。也即， s2总是s1s1的子串。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isRotation(String s1, String s2) {

        if (s1 == null && s2 == null) {
            return true;
        }

        if (s1 == null || s2 == null) {
            return false;
        }

        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    private boolean isSubstring(String s1s1, String s2) {
        return s1s1.substring(1).contains(s2);
    }
}
