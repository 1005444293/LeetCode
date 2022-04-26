public class LC700_二叉搜索树中的搜索 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        //递归终止条件
        if (root == null || root.val == val) return root;
        //单层递归逻辑
        //如果当前节点大于所给值，那么就往左子树递归，否则往右子树递归
        if (root.val > val) return searchBST(root.left, val);
        if (root.val < val) return searchBST(root.right, val);
        return null;
    }
}
