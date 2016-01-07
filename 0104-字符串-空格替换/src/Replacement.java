/**
 * Author: 王俊超
 * Date: 2016-01-07 09:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        int space = 0;
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' ') {
                space++;
            }
        }

        char[] result = new char[length + 2 * space];

        for (int i = length - 1, j = result.length; i >= 0; i--) {
            char c = iniString.charAt(i);
            if (c == ' ') {
                result[--j] = '0';
                result[--j] = '2';
                result[--j] = '%';
            } else {
                result[--j] = c;
            }
        }

        return new String(result);
    }
}
