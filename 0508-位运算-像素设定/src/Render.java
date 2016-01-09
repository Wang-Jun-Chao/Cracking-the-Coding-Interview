/**
 * Author: 王俊超
 * Date: 2016-01-09 14:09
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Render {
    public int[] renderPixel(int[] screen, int x, int y) {

        int i = x / 8;
        int j = y / 8;

        // 说明在一个子字内
        if (i == j) {
            // 最右边连续x-y+1个1，
            int a = (1 << (y - x + 1)) - 1;
            // 左移的位数
            int m = x % 8;
            screen[i] |= a << m;
        }
        // 至少分布在两个字节内
        else {

            // 设置第一个字节
            // 最右边连续x-y+1个1
            int a = (1 << (8 - x % 8)) - 1;
            // 左移的位数
            int m = x % 8;
            screen[i] |= a << m;


            // 设置最后一个字节
            // 1的个数
            a = (1 << (y % 8 + 1)) - 1;
            screen[j] |= a;

            i++;
            // [i+1, ... ,j-1]所有的1连续
            while (i < j) {
                screen[i] = 255;
                i++;
            }
        }


        return screen;
    }
}
