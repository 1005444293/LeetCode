public class LC404_左叶子之和 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        //递归终止条件
        if (root == null) return 0;
        //考虑二叉树的遍历顺序，因为要根据递归函数的返回值计算左叶子结点之和
        //所以要使用后序遍历（左右中）的顺序对叶子结点进行累计加和
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);
        int midValue = 0;
        //判断一个结点为左叶子结点：当前节点的左孩子结点不为空，但该左孩子结点的左右孩子结点都为空，表明是一个左孩子结点
        if (root.left != null && root.left.left == null && root.left.right == null){
            midValue = root.left.val;
        }
        //将左右子树的左孩子结点的值累加起来返回
        return midValue + leftValue + rightValue;
    }
}
