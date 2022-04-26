public class LC116_填充每个节点的下一个右侧指针 {
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
    public Node connect(Node root) {
        //首先判断根节点是否为空
        if (root == null) return null;
        //如果root不是叶子结点的话，进入if条件中
        if (root.left != null){
            //将左孩子结点的next指针指向右孩子结点
            root.left.next = root.right;
            //将两个相邻的父节点1,2，将1的右孩子结点的next指针指向2的左孩子结点
            if (root.next != null){
                root.right.next = root.next.left;
            }
        }
        //递归根节点的左右孩子结点
        connect(root.left);
        connect(root.right);
        //返回重新构建的树的根节点
        return root;
    }
}
