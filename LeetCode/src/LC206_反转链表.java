/**
 * 题意：反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 *
 * 思路：构造两个指针，用于反转链表
 */
public class LC206_反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = null;
        while (head != null){
            //使cur指向头节点的下一个节点
            cur = head.next;
            //反转头节点的指向
            head.next = pre;
            //重新构建节点的指向
            pre = head;
            head = cur;
        }
        //退出循环时，head节点已经指向null，所以应该返回pre
        return pre;
    }
}
