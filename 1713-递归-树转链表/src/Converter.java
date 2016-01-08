/**
 * Author: 王俊超
 * Date: 2016-01-08 08:36
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Converter {
    public ListNode treeToList(TreeNode root) {
        ListNode[] head = new ListNode[1];
        ListNode[] tail = new ListNode[1];
        treeToList(root, head, tail);

        return head[0];
    }


    /**
     * 将二叉树转成单链表
     *
     * @param root 树根结点
     * @param tail 以root为根结点，所转换成的单链表后的尾结点，使用tail[0]进行保存
     * @param head 以root为根结点，所转换成的单链表后的头结点，使用head[0]进行保存
     */
    public void treeToList(TreeNode root, ListNode[] head, ListNode[] tail) {

        // 如果根结点为null就直接返回
        if (root == null) {
            head[0] = null;
            tail[0] = null;
            return;
        }

        ListNode[] leHead = new ListNode[1];
        ListNode[] leTail = new ListNode[1];

        ListNode[] riHead = new ListNode[1];
        ListNode[] riTail = new ListNode[1];

        // 求左子树的单链表
        treeToList(root.left, leHead, leTail);
        // 求右子树的单链表
        treeToList(root.right, riHead, riTail);

        // 创建链表结点
        ListNode node = new ListNode(root.val);


        // 如果没有左子树，则leTail[0]也为null
        if (leHead[0] == null) {
            head[0] = node;
        } else {
            head[0] = leHead[0];
        }

        // 如果没有右子树，则riHead[0]也为null
        if (riTail[0] == null) {
            tail[0] = node;
        } else {
            tail[0] = riTail[0];
        }

        // 如果左子树不为空，则有尾结点，串成链
        if (leTail[0] != null) {
            leTail[0].next = node;
        }

        // 如果右子树不空，则有头结点，串成链
        if (riHead[0] != null) {
            node.next = riHead[0];
        }
    }
}
