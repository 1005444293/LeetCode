import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC559_N叉树的最大深度迭代法 {
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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                if (tmp != null){
                    if (tmp.children.get(i) != null) queue.add(tmp.children.get(i));
                }
            }
        }
        return depth + 1;
    }
}
