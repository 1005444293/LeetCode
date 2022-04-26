public class LC110_平衡二叉树 {
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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }

    private int getHeight(TreeNode root) {
        //递归的终止条件
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
            return 1 + Math.max(left, right);
        }else {
            return -1;
        }
    }
}
