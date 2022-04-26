import java.util.ArrayList;
import java.util.List;

public class LC589_N叉树的前序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        //递归结束标志
        if (root == null) return res;
        res.add(root.val);
        int size = root.children.size();
        for (int i = 0; i < size; i++) {
            preorder(root.children.get(i));
        }
        return res;
    }
}
