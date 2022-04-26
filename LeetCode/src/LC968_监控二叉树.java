public class LC968_监控二叉树 {
    private int result;
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
    public int minCameraCover(TreeNode root) {
        result = 0;

        //情况4
        if (traversal(root) == 0){
            result++;
        }
        return result;
    }

    private int traversal(TreeNode root) {
        //递归终止条件，该节点有覆盖
        if (root == null) return 2;
        //使用后序遍历，左右中的顺序，对二叉树从低向上
        //递归，根据其左右孩子结点的返回值再进行判断处理
        int left = traversal(root.left);
        int right = traversal(root.right);
        //情况1：左右节点都有覆盖，例如叶子结点的父节点放了摄像头
        //其上一层被覆盖，但再向上一层的节点就没有被覆盖
        if (left == 2 &&  right == 2){
            return 0;
        }
        //情况2
        //left==0 && right==0 左右节点无覆盖
        //left==0 && right==1 左节点无覆盖，右节点有摄像头
        //left==1 && right==0 左节点有摄像头，右节点无覆盖
        //left==0 && right==2 左节点无覆盖，右节点有覆盖
        //left==2 && right==0 左节点有覆盖，右节点无覆盖
        if (left == 0 || right == 0){
            result++;
            return 1;
        }
        //情况3
        //left==1 && right==2 左节点有摄像头，右节点有覆盖
        //left==2 && right==1 左节点有覆盖，右节点有摄像头
        //left==1 && right==1 左右节点都有摄像头
        if (left == 1 || right == 1){
            return 2;
        }
        return -1;
    }
}
