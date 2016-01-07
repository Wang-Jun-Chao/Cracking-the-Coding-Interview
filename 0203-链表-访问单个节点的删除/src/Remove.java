/**
 * Author: 王俊超
 * Date: 2016-01-07 10:07
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {

        if (pNode == null) {
            return false;
        }

        ListNode n = pNode.next;
        if (n != null) {
            // 删除掉下一个结点，并且把下一个结点的值放到当前结点，达到删除当前结点的目地
            pNode.val = n.val;
            pNode.next = n.next;
            return true;
        } else {
            return false;
        }
    }
}
