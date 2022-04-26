import java.util.LinkedList;
import java.util.Queue;

public class LC222_完全二叉树的结点个数 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //迭代
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            //此处不能有num++，因为这会导致除根节点以外的其他节点被重复计算
            //将num++放到if条件判断中，如果有孩子结点，num就自增1
            //num++;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null){
                    num++;
                    queue.add(tmp.left);
                }
                if (tmp.right != null){
                    num++;
                    queue.add(tmp.right);
                }
            }
        }
        return num;
    }

    //递归
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        //递归的顺序是左右中（后序遍历）
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return left + right + 1;
    }
}
