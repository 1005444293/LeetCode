/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 思路：①不添加虚节点，需要针对头节点的情况进行判断，当头结点的值与定值val相等时，需要将头结点从链表中移除，而头结点的移除与其余节点的移除
 *      步骤并不完全相同，因为头节点没有上一个节点，然后再针对其余节点进行处理
 *      ②添加虚节点，在头节点之前添加一个虚节点，使头节点与链表中的其他节点具有相同的结构，即同样具有前节点和后节点，只需判断每一个节点的值
 *      是否与所给定值相等，然后进行处理即可
 */
public class LC203_移除链表元素 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 不添加虚节点
     * @param head 所给链表
     * @param val 所给定的值
     * @return 返回新的链表
     */
    public ListNode removeElements1(ListNode head, int val) {
        //首先对头节点的情况给予判断
        while (head != null && head.val == val){
            head = head.next;
        }
        //判断头节点是否为空，为空则可结束判断
        if (head == null){
            return null;
        }
        //此事已经确定head != null，针对其他节点进行处理，创建两个指针
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 添加虚节点使头节点成为与链表中其它节点具有相同结构的节点
     * @param head 所给链表
     * @param val 所给值
     * @return 返回新的链表
     */
    public ListNode removeElements2(ListNode head, int val){
        //判断所给链表是否为空，若为空，则可直接返回
        if (head == null){
            return head;
        }
        //创建虚节点
        ListNode node = new ListNode(0, head);
        //创建两个指针，分别指向虚节点和链表的头节点
        ListNode pre = node;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return node.next;
    }
}
