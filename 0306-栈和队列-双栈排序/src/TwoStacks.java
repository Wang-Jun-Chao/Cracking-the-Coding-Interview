import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: 王俊超
 * Date: 2016-01-07 10:12
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {

        // 将result看作栈，最后一个元素看作栈顶
        ArrayList<Integer> result = new ArrayList<>(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            // 如果结果集为空，或者大于等于最后一个元素
            if (result.isEmpty() || n >= result.get(result.size() - 1)) {
                result.add(n);
            } else {
                int j;
                int k = i;

                // 在栈中删除比n大的元素
                do {
                    // 删除最后一个元素
                    j = result.remove(result.size() - 1);
                    numbers[k] = j;
                    k--;
                } while (!result.isEmpty() && result.get(result.size() - 1) > n);


                // 添加元素
                result.add(n);
                // 将删除的元素再添加回栈中
                for (int l = k + 1; l <= i; l++) {
                    result.add(numbers[l]);
                }
            }

        }

        // 因为栈顶是最后一个元素，所以还得把栈翻转过来
        Collections.reverse(result);
        return result;
    }
}
