/**
 * Author: 王俊超
 * Date: 2016-01-07 09:43
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {

        if (k < 1) {
            return null;
        }

        // 头结点
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode prev = root;
        ListNode next = root;

        // 先移动k步
        for (int i = 0; i < k && prev != null; i++) {
            prev = prev.next;
        }

        // 为null说明链表没有k个结点
        if (prev == null) {
            return null;
        }

        while (prev != null) {
            prev = prev.next;
            next = next.next;
        }

        return next;
    }
}
