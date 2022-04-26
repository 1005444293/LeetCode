public class LC106_从中序与后序遍历序列构造二叉树 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return travel(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode travel(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        //如果数组的开始和结束索引相同，递归结束
        if (inBegin == inEnd) return null;
        //后序遍历的最后一个结点是树的根节点
        int tmp = postorder[postEnd - 1];
        //构建树的根节点
        TreeNode root = new TreeNode(tmp);
        //如果后续遍历数组长度为1，则返回根节点
        if (postEnd - postBegin == 1) return root;
        //在中序遍历数组中找到该根节点的索引，以便后续对数组进行分割
        int index;
        for (index = inBegin; index < inEnd; index++) {
            if (inorder[index] == tmp){
                break;
            }
        }
        //根据索引index对中序数组进行分割，一定要按照左闭右开[)的原则划分数组
        int beginLeftIn = inBegin;
        int endLeftIn = index;
        int beginRightIn = index+1;
        int endRightIn = inEnd;
        //根据中序遍历和后序遍历数组的长度相同对后续数组进行分割，一定要按照左闭右开[)的原则划分数组
        int beginLeftPost = postBegin;
        int endLeftPost = postBegin + index - inBegin;
        int beginRightPost = endLeftPost;
        int endRightPost = postEnd - 1;
        //递归构造树
        root.left = travel(inorder, beginLeftIn, endLeftIn, postorder, beginLeftPost,endLeftPost);
        root.right = travel(inorder, beginRightIn, endRightIn, postorder, beginRightPost, endRightPost);
        return root;
    }
}
