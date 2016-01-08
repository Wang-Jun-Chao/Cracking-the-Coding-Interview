/**
 * Author: 王俊超
 * Date: 2016-01-07 21:20
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Exchange {
    public int[] exchangeAB(int[] AB) {

        // 令a=AB[0],b=AB[1]
        AB[0] ^= AB[1]; // a1 = a^b;
        AB[1] ^= AB[0]; // b = b^a1 = b^a^b = b;
        AB[0] ^= AB[1]; // a = b^a1 = b^a^b = a;

        return AB;
    }
}
