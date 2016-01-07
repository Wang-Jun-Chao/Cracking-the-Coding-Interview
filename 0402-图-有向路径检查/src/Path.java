import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Author: 王俊超
 * Date: 2016-01-07 10:55
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Path {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {

        if (a == null || b == null) {
            return false;
        }

        if (hasPath(a, b) || hasPath(b, a)){
            return true;
        }


        return false;
    }

    private boolean hasPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // 下在从a点开始使用广度优先遍历方式找a到b是否有路径
        // 待访问结点队列
        List<UndirectedGraphNode> list = new LinkedList<>();
        // 已经访问的结点
        Set<UndirectedGraphNode> set = new HashSet<>();
        list.add(a);
        while (!list.isEmpty()) {
            UndirectedGraphNode node = list.remove(0);
            set.add(node);
            if (node == b) {
                return true;
            } else {
                for (UndirectedGraphNode n : node.neighbors) {
                    // 如果n没有被访问过
                    if (!set.contains(n)) {
                        list.add(n);
                    }
                }
            }
        }
        return false;
    }
}
