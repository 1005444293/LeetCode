import java.util.ArrayList;

public class LC_剑指OfferII_26 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p);
            p = p.next;
        }

        int len = list.size();
        int i = 0;
        int j = len - 1;
        while (i < j){
            list.get(j).next = list.get(i).next;
            list.get(i).next = list.get(j);
            i++;
            j--;
        }
        list.get(i).next = null;
    }
}















