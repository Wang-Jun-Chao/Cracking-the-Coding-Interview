import java.util.Arrays;

/**
 * Author: 王俊超
 * Date: 2016-01-12 08:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Substr s = new Substr();

        String[] p = {"a", "b", "c", "d"};
        String str = "abc";
        System.out.println(Arrays.toString(s.chkSubStr(p, p.length, str)));

        p = new String[]{"bav", "yacv", "wez", "p", "zei", "m", "ypx", "oqlz",
                "by", "tudp", "vcwb", "bwkw", "tjc", "hs", "gbjg", "c", "qmfe",
                "wvc", "cw"};
        str = "bwkwby";
        System.out.println(Arrays.toString(s.chkSubStr(p, p.length, str)));
    }
}
