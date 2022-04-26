public class LC337_打家劫舍III {
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
    public int rob(TreeNode root) {
        int[] res = robRoot(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robRoot(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = robRoot(root.left);
        int[] right = robRoot(root.right);
        //偷当前这家
        int val1 = root.val + left[0] + right[0];
        //不偷当前这家
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val1, val2};
    }

}
