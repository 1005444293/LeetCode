
/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]
 *
 * 思路：使用双指针完成，注意为了使头节点的处理与其他节点方法相同，需要构造一个虚节点作为辅助。
 *      ①构造虚节点和快慢指针，先让快慢指针都指向虚节点
 *      ②快指针先移动n+1步，目的是当快指针指向链表尾部的null时，慢指针此时指向需要移除节点的前一个节点
 *      ③移除目标节点
 */
public class LC19_删除链表的倒数第N个节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //构造虚节点
        ListNode p = new ListNode(0, head);
        //构造快慢指针
        ListNode fast = p;
        ListNode slow = p;
        //先让fast指针走n步
        while (n-- > 0 && fast != null){
            fast = fast.next;
        }
        //fast指针再向前走一步，目的是当fast指向null的时候slow可以指向目标节点的上一个节点
        fast = fast.next;
        //快慢指针同时向前走
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //移除目标节点
        slow.next = slow.next.next;
        return p.next;
    }
}
