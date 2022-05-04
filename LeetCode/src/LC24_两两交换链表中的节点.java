/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 思路：构造一个虚拟节点指向链表的头节点，原链表：1->2->3->4，构造虚拟节点0后：0->1->2->3->4，再构造一个cur指针指向虚拟节点，
 *      L指针指向1，R指向2，步骤如下：
 *      ①先将cur节点的next指针指向R
 *      ②其次将L的next指针指向R.next，即3
 *      ③再将R的next指针指向L，即2->1
 *      ④将cur指针后移两位到1
 *      如此循环上述过程即可
 */
public class LC24_两两交换链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        //对所给链表进行判断
        if (head == null || head.next == null){
            return head;
        }
        //构造虚拟节点
        ListNode p = new ListNode(0, head);
        //构造指向p的指针
        ListNode cur = p;

        //进入循环，交换链表节点顺序
        while (cur.next != null && cur.next.next != null){
            //构造L、R指针分别指向cur指向节点的next节点和next.next节点
            ListNode L = cur.next;
            ListNode R = cur.next.next;
            //开始按照思路中的①、②、③步骤交换顺序
            cur.next = R;
            L.next = R.next;
            R.next = L;
            //将cur后移至交换顺序后的L位置，便于进行下一次循环
            cur = L;
        }
        return p.next;
    }
}
