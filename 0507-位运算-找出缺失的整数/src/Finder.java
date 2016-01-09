import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2016-01-09 10:27
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Finder {
    /**
     * <pre>
     * 考查最后一位，在0到n的数中，若n为奇数，
     * 则0和1的数量相同;若n为偶数，则0比1的数量多一个，也就是说:
     * 若 n % 2 == 1 ，则count(0s) = count(1s)
     * 若 n % 2 == 0 , 则count(0s) = 1 + count(1s)
     * 由此可见. count(0S)必定大于或等于count(1s) 。
     * 从这列数中移除数值v后，只要检查其他数值的最低有效位，马上就能知道v是偶数还是奇数。
     * 在上一步中，我们可以排除了一半的数字
     *
     * 在剩下的数中考查第二个最低有效位(LSB2 )
     * 发现如下规律 (其中count2表示第二个最低有效位中0或1的个数):
     * count2(0s) = count2(1s) 或count2(0s) = 1 + count2(1s)
     * 同样的，我们可以得出以下结论:
     * 若 count2(0s) <= count2(1s) ，则LSB2(v) = 0
     * 若 count2(0s) > count2(1s) ，则LSÐz(v) = 1
     *
     * 重复上述操作可以找出每个位
     * </pre>
     *
     * @param numbers
     * @param n
     * @return
     */
    public int findMissing(int[][] numbers, int n) {
        // 不考虑输入错误的情况

        int rs = 0;

        // 给出的数字中，数字用二进制表示的最大长度
        int len = numbers[numbers.length - 1].length;

        List<int[]> initList = new ArrayList<>(numbers.length);
        List<int[]> zeroList = new ArrayList<>(numbers.length / 2);
        List<int[]> oneList = new ArrayList<>(numbers.length / 2);

        Collections.addAll(initList, numbers);

        // 对每一位数进行处理，最低位为第0位
        for (int i = 0; i < len; i++) {
            // 处理每一个数字
            int zero = 0;
            int one = 0;
            // 处理所有数的第i位
            for (int[] v : initList) {
                if (v.length <= i || v[i] == 0) {
                    zero++;
                    zeroList.add(v);
                } else {
                    one++;
                    oneList.add(v);
                }
            }

            // 零比一多，说明第i位应该是1
            if (zero > one) {
                rs |= (1 << i);

                List<int[]> temp = initList;
                initList = oneList;
                oneList = temp;
            } else {
                List<int[]> temp = initList;
                initList = zeroList;
                zeroList = temp;
            }

            zeroList.clear();
            oneList.clear();
        }

        return rs;
    }
}
