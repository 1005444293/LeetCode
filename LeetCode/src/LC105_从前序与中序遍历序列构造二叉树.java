
/**
 *https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 */
public class LC105_从前序与中序遍历序列构造二叉树 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return travel(preorder, 0, preorder.length, inorder,0, inorder.length);
    }

    private TreeNode travel(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        //当数组的preBegin == preEnd的时候，递归结束
        if (preBegin == preEnd) return null;
        //前序遍历数组的第一个元素是根节点
        int tmp = preorder[preBegin];
        //创建二叉树的根节点
        TreeNode root = new TreeNode(tmp);
        if (preEnd - preBegin == 1) return root;
        //找到根节点在中序遍历数组中的位置
        int index = 0;
        for (index = inBegin; index < inEnd; index++) {
            if (inorder[index] == index)
                break;
        }
        //根据二叉树的前序遍历和中序遍历数组长度相同，对中序遍历数组进行分割，左闭右开
        int inLeftBegin = inBegin;
        int inLeftEnd = index;
        int inRightBegin = index + 1;
        int inRightEnd = inEnd;
        //根据二叉树的前序遍历和中序遍历数组长度相同，对前序遍历数组进行分割
        int preLeftBegin = preBegin + 1;
        int preLeftEnd = preBegin + 1 + index - inBegin;
        int preRightBegin = preLeftEnd;
        int preRightEnd = preEnd;
        //递归
        root.left = travel(preorder, preLeftBegin, preLeftEnd, inorder, inLeftBegin, inLeftEnd);
        root.right = travel(preorder, preRightBegin, preRightEnd, inorder, inRightBegin, inRightEnd);
        return root;
    }
}
