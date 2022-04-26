import java.util.ArrayList;
import java.util.List;

public class LC113_路径总和II {
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
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        list.add(root.val);
        travel(root, targetSum-root.val);
        return res;
    }

    private static void travel(TreeNode root, int num) {
        if (root.left == null && root.right == null && num == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        if (root.left != null){
            list.add(root.left.val);
            travel(root.left, num-root.left.val);
            num += root.left.val;
            list.remove(list.size()-1);
        }
        if (root.right != null){
            list.add(root.right.val);
            travel(root.right, num-root.right.val);
            num += root.right.val;
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        r1.left = r2;
        r1.right = r3;
        int tar = 3;
        List<List<Integer>> result = pathSum(r1, tar);
        System.out.println(result);
    }
}
