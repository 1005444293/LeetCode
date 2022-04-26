import java.util.Arrays;

public class LC654_最大二叉树 {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return travel(nums, 0, nums.length);
    }

    //构造树使用前序遍历，根左右的顺序
    private TreeNode travel(int[] nums, int left, int right) {
        //当左右索引相等时，证明到达叶子结点，递归结束
        if (left == right){
            return null;
        }
        //找到数组中的最大值的索引
        int index = maxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        //根据最大值的索引继续递归
        root.left = travel(nums, left, index);
        root.right = travel(nums, index+1, right);
        return root;
    }

    private int maxIndex(int[] nums, int left, int right) {
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[index]){
                index = i;
            }
        }
        return index;
    }
}
