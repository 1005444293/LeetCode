
/**
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 *                        如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 思路：①不添加虚拟节点
 *      ②添加虚拟节点
 */

//定义链表节点结构
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {

    //size存储链表元素的个数
    int size;
    //虚拟头节点
    ListNode head;

    //初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * 获取索引为index的节点值
     * @param index 所给索引
     * @return 返回index对应的节点值
     */
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        //如果是空链表，头节点应该也为空，但是我们初始化链表时添加了一个头节点（虚拟节点）
        //所以在寻找链表第index个元素时，应该找到第index+1个
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 在链表的最前面插入一个节点，插入完成后，新插入的节点为链表的新的头节点
     * @param val 新节点的值
     */
    public void addAtHead(int val) {
        //先构造新的节点
        ListNode node = new ListNode(val);
        //使新的节点指向当前链表的头节点
        node.next = head.next;
        //使虚拟节点指向当前新的头节点
        head.next = node;
        //将链表的长度自增
        size++;
    }

    /**
     * 在链表的尾部增加一个节点
     * @param val
     */
    public void addAtTail(int val) {
        //构造尾节点
        ListNode node = new ListNode(val);
        //cur指针指向虚拟节点，用于后续寻找尾节点的位置
        ListNode cur = head;
        //寻找尾节点
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        //链表长度自增
        size++;
    }

    /**
     * 在指定索引位置添加节点
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        //如果index大于当前链表的长度，返回空
        if (index > size){
            return;
        }
        //如果index<0，则将该节点添加到头节点
        if (index < 0){
            index = 0;
        }
        //构造新节点
        ListNode node = new ListNode(val);
        ListNode cur = head;
        while (index-- > 0){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    /**
     * 删除索引为index的链表节点
     * @param index
     */
    public void deleteAtIndex(int index) {
        //如果index>/<size，返回空
        if (index >= size || size < 0){
            return;
        }
        ListNode cur = head;
        while (index-- > 0){
            cur = cur.next;
        }
        //使索引为index的节点的前节点直接指向其侯洁典，起到删除索引为index的节点的效果
        cur.next = cur.next.next;
    }
}
