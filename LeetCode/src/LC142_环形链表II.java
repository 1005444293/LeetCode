/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链
 * 表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果
 * pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 *
 * 思路：使用快慢指针解决，首先设置快慢指针fast、slow同时指向链表的头节点，快指针一次走两步，慢指针一次走一步，如果二者能够相遇，
 *      则表明所给链表中有环，此时设置两个指针p和q，p指向fast和slow相遇的位置，q指向链表的头节点，让p和q同时开始走，每次走一步，
 *      当二者相遇时，便是环的入口，具体数学推理过程见：
 *      https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
 */
public class LC142_环形链表II {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //链表有环
            if (slow == fast){
                ListNode p = fast;
                ListNode q = head;
                while (p != q){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}











