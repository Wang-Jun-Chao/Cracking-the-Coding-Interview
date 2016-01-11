import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2016-01-11 10:14
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Joseph {
    public int getResult(int n) {
        List<Integer> list = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int step = 2;
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if ((i + 1) % step == 1) {
                    left.add(list.get(i));
                }
            }

            int last = left.remove(left.size() - 1);
            left.add(0, last);
            list.clear();

            List<Integer> tmp = list;
            list = left;
            left = tmp;
            step++;
        }

        return list.get(0);
    }
}
