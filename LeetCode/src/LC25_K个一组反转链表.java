/**
 * 题解 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-java-by-reedfan-2/
 */
public class LC25_K个一组反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        //定义一个节点指向head
        ListNode tail = head;
        //找到head后面第k个结点的位置，用tail指向它
        for (int i = 0; i < k; i++) {
            //如果链表剩余的长度小于k，直接返回head即可
            if (tail == null){
                return head;
            }
            tail = tail.next;
        }
        //定义一个新节点，表示反转后链表的头结点,反转链表的范围就是head到tail之间，不包括tail结点
        ListNode newHead = reverse(head, tail);
        newHead.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null) return head;
        //定义两个节点，用于反转链表
        ListNode pre = null;
        ListNode cur = null;
        while (head != tail){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
}
















