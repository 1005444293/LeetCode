import java.util.ArrayList;
import java.util.List;

public class LC257_二叉树的所有路径 {
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        solve(root, "", res);
        return res;
    }

    private void solve(TreeNode root, String s, List<String> res) {
        if (root == null) return;
        //如果不是叶子结点就把该节点拼接在路径上
        s += root.val;
        //如果该节点的左右孩子结点都为空，则表明该节点就是叶子结点(如何判断一条路径到达终点)
        if (root.left == null && root.right == null){
            res.add(s);
        }else {
            //如果该节点不是叶子结点，就表明当前这条路线还没走到也自己结点
            solve(root.left, s+"->", res);
            solve(root.right, s+"->", res);
        }
    }
}
