import java.util.LinkedList;
import java.util.Queue;

public class LC111_二叉树的最小深度递归_迭代 {
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

    /**
     * 递归法
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        if (root.left == null && root.right != null){
            return right+1;
        }
        if (root.right == null && root.left != null){
            return left+1;
        }
        return Math.min(left, right)+1;
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                //当某个结点有左孩子结点或者右孩子结点或二者都有的时候，就表明没有到达叶子结点
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                //当某结点左右孩子都为空时，即到达了叶子结点位置，返回depth即可
                if (tmp.left == null && tmp.right == null) return depth;
            }
        }
        return depth;
    }
}
