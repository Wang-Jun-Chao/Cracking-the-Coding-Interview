/**
 * Author: 王俊超
 * Date: 2016-01-11 16:44
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class ToString {

    public final static String[] DIGITS = {"One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine"};
    public final static String[] TEENS = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public final static String[] TENS = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    public final static String[] BIGS = {"", "Thousand", "Million", "Billion", "Trillion"};

    public String toString(int x) {
        if (x == 0) {
            return "Zero";
        } else if (x < 0) {
            return "Negative " + toString(-x);
        }

        int count = 0;
        String rs = "";
        while (x > 0) {

            if (x % 1000 != 0) {
                rs = less1000toString(x % 1000) + BIGS[count] + (x > 1000 ? "," : ",") + rs;
            }

            x /= 1000;
            count++;

        }

        rs = rs.trim();
        if (rs.endsWith(",")) {
            return rs.trim().substring(0, rs.length() - 1).trim();
        } else {
            return rs;
        }


    }

    public String less1000toString(int x) {
        String rs = "";

        if (x > 100) {
            rs += DIGITS[x / 100 - 1] + " Hundred ";
            x %= 100;
        }

        if (x >= 11 && x <= 19) {
            return rs + TEENS[x - 11] + " ";
        } else if (x == 10 || x >= 20) {
            rs += TENS[x / 10 - 1] + " ";
            x %= 10;
        }

        if (x >= 1 && x <= 9) {
            rs += DIGITS[x - 1] + " ";
        }

        return rs;

    }
}
