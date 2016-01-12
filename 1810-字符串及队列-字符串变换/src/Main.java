/**
 * Author: 王俊超
 * Date: 2016-01-12 09:40
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        Change c = new Change();
        String[] dic = {"abc", "adc", "bdc", "aaa"};
        String start = "abc";
        String stop = "bdc";
        System.out.println(c.countChanges(dic, dic.length, start, stop));
    }
}
