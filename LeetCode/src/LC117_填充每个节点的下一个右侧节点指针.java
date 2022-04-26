public class LC117_填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    // 先确保 root.right 下的节点的已完全连接，因 root.left 下的节点的连接
    // 需要 root.left.next 下的节点的信息，若 root.right 下的节点未完全连
    // 接（即先对 root.left 递归），则 root.left.next 下的信息链不完整，将
    // 返回错误的信息。可能出现的错误情况如下图所示。此时，底层最左边节点将无
    // 法获得正确的 next 信息：
    //                  o root
    //                 / \
    //     root.left  o —— o  root.right
    //               /    / \
    //              o —— o   o
    //             /        / \
    //            o        o   o
    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left != null && root.right != null){
            root.left.next = root.right;
        }

        if (root.left != null && root.right == null){
            root.left.next = getNext(root.next);
        }
        if (root.right != null){
            root.right.next = getNext(root.next);
        }
        //递归的时候，应该先递归右支，因为左支的next指针可能需要指向右支
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root) {
        if (root == null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        if (root.next != null) return getNext(root.next);
        return null;
    }
}
