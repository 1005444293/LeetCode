import java.nio.file.ProviderNotFoundException;

/**
 * 解题题解 https://leetcode-cn.com/problems/convert-bst-to-greater-tree/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-7q9g/
 */
public class LC538_把二叉搜索树转换为累加树 {
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
    private int pre;//记录当前结点的前一个值
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    private void traversal(TreeNode cur) {
        //如果当前节点为空则返回
        if (cur == null) return;
        //反中序遍历，右根左的顺序
        traversal(cur.right);
        //处理根节点的值时，需要累加其右边所有结点的值
        //而pre就是用来记录当前节点的前边各个节点的累加值
        cur.val += pre;
        //当前结点累加以后，用pre记录当前节点的累加值，然后
        //可以继续递归
        pre = cur.val;
        traversal(cur.left);
    }
}
