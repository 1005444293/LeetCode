/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构
 *
 * 例如：A：a1->a2->c1->c2->c3；B：b1->b2->b3->c1->c2->c3 需要找出两个链表的交点，即c1
 *
 * 思路：构造两个指针p和q，分别指向链表A和B，然后一直向后移动，当p指向A的尾端时，再继续向B移动，q先从B的头节点开始，移动到B的尾节点时
 *      再继续向A链表移动，直到p个q相同跳出循环
 */
public class LC0207_链表相交 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //构造两个指针分别指向链表A和B
        ListNode p = headA;
        ListNode q = headB;
        //当p == q的时候跳出循环
        while (p != q){
            //p先从A的头节点向后移动
            if (p != null){
                p = p.next;
            }else {
                p = headB;
            }
            //q先从B的头节点向后移动
            if (q != null){
                q = q.next;
            }else {
                q = headA;
            }
        }
        return p;
    }
}
