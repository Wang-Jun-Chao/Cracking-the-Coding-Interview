import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复结点。
 * 进阶
 * 如果不得用临时理缓冲区，该怎么解决？
 * Author: 王俊超
 * Date: 2015-10-16
 * Time: 16:04
 * Declaration: All Rights Reserved !!!
 */
public class Solution01 {

    private static class LinkedListNode {
        int data;
        LinkedListNode next;
    }

    /**
     * 解法
     * 要想移除链表中的重复结点，我们需要设法记录有哪些是重复的。这里只要用到一个简单的
     * 散列表。
     * 在下面的解法中，我们会直接迭代访问整个链表，将每个结点加入散列表。若发现有重复元
     * 素，则将该结点从链表中移除，然后继续迭代。
     * 代码的时间复杂度为O(N) ，其中N为链表结点数目。
     *
     * @param n
     */
    public static void deleteDups(LinkedListNode n) {
        Set<LinkedListNode> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n)) {
                previous.next = n.next;
            } else {
                set.add(n);
                previous = n;
            }
            n = n.next;
        }
    }

    /**
     * 进阶： 不得使用缓冲区
     * 如不借助额外的缓冲区，可以用两个指针来迭代： current迭代访问整个链表，runner用于
     * 检查后续的结点是否重复。
     *
     * @param head
     */
    public static void deleteDups2(LinkedListNode head) {
        if (head == null) {
            return;
        }

        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current.next;
            while (runner.next != null) {
                // 如果有相同的就去掉重复节点
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    // 不相同就移动到下一个节点
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
