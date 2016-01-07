/**
 * Author: 王俊超
 * Date: 2016-01-07 13:28
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class CloseNumber {
    public int[] getCloseNumber(int x) {
        int[] result = {0, 0};

        int one = 0;
        int zero = 0;
        int and = 1;

        // 从最低位置向最高位操作

        // 找第一位0的位置
        while ((x & and) == 1) {
            zero++;
            and <<= 1;
        }
        and = 1;
        // 找第一位1出现的位置
        while ((x & and) == 0) {
            one++;
            and <<= 1;
        }

        // 产生第一个结果
        int t = 0xFFFF_FFFF;
        t ^= (1 << one);
        result[0] = x | (1 << zero) & t;

        // 这两位交换后会产生一个小于x的值
        if (zero < one) {
//            int t = 0xFFFF_FFFF;
//            t ^= (1 << one);
//            result[0] = x | (1 << zero) | t;

            zero = one + 1;
            and = (1 << zero);

            // 找第二个0，第一个1还是使用
            while ((x & and) == 1) {
                zero++;
                and <<= 1;
            }

            // 第二个结果
            t = 0xFFFF_FFFF;
            t ^= (1 << one);
            result[1] = x | (1 << zero) & t;

        }
        // 这两位交换后会产生一个大于x的值
        else {

            one++;
            zero = one;

            // 找第二位0的位置
            and = (1 << zero);
            while ((x & and) == 1) {
                zero++;
                and <<= 1;
            }
            and = (1 << one);
            // 找第一位1出现的位置
            while ((x & and) == 0) {
                one++;
                and <<= 1;
            }

            // 第二个结果
            t = 0xFFFF_FFFF;
            t ^= (1 << one);
            result[1] = x | (1 << zero) & t;
        }


        return result;
    }
}
