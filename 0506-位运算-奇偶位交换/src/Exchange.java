/**
 * Author: 王俊超
 * Date: 2016-01-09 10:14
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Exchange {
    public int exchangeOddEven(int x) {
        return ((x & 0xAA_AA_AA_AA) >> 1) | ((x & 0x55_55_55_55) << 1);
    }
}
