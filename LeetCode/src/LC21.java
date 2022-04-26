import java.util.ListIterator;

/**
 * 合并两个有序链表：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 思路：创建一个链表以及一个指针指向新创建的链表，挨个比较l1和l2中数值的大小，将指针prev指向较小者，然后后移较小者的指针指向
 *      当l1或者l2有一个或同时为空，便查看另一个链表是否还有结点，有的话直接添加到指针后即可
 */


public class LC21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode prev = p;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //判断链表l1是否还有结点，有的话直接加到prev后，此处不能用while循环
        if (l1 != null){
            prev.next = l1;
        }
        if (l2 != null){
            prev.next = l2;
        }
        return p.next;
    }
}
