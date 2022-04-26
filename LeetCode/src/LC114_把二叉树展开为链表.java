import java.util.ArrayList;

public class LC114_把二叉树展开为链表 {
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

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preOrder(list, root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrder(ArrayList<TreeNode> list, TreeNode root) {
        if (root == null) return;
        list.add(root);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

}
