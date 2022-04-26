public class LC112_路径总和 {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return travle(root, targetSum-root.val);
    }

    private boolean travle(TreeNode root, int num) {
        if (root.left == null && root.right == null && num == 0) return true;
        if (root.left == null && root.right == null) return false;
        if (root.left != null){
            num -= root.left.val;
            if (travle(root.left, num)){
                return true;
            }
            num += root.left.val;
        }
        if (root.right != null){
            num -= root.right.val;
            if (travle(root.right, num)){
                return true;
            }
            num += root.right.val;
        }
        return false;
    }


}
