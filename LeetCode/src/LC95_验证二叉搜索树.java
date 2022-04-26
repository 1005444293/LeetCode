public class LC95_验证二叉搜索树 {
    public static class TreeNode {
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
    //创建一个辅助节点，记录每次递归的前一个节点
    static TreeNode pre = null;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //单层递归逻辑
        boolean left = isValidBST(root.left);
        //因为是中序遍历，先递归到二叉树的最左边的左子树，然后向上回溯的过程中
        //pre记录左子树的节点，如果左子树的值大于等于其父节点的值，就证明这不是
        //一棵二叉搜索树，相同的，当递归右子树时，pre记录的是父节点，如果父节点
        //的值大于等于右孩子节点的值，就表明这不是一棵二叉搜索树
        if (pre != null && pre.val >= root.val) return false;
        //记录前一个节点
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(3);
        r1.left = r2;
        r1.right = r3;

        boolean res = isValidBST(r1);
        System.out.println(res);
    }
}
