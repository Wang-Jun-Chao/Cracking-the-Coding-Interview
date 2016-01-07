/**
 * Author: 王俊超
 * Date: 2016-01-07 09:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static ListNode makeList() {
        ListNode head = new ListNode(1);
        ListNode next = head;

        for (int i = 2; i <= 9; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = makeList();
        Solution s = new Solution();

        for (int i = 1; i <= 10; i++) {
            ListNode n = s.FindKthToTail(head, i);
            System.out.println(n == null ? null : n.val);
        }
    }
}
