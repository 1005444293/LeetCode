public class LC96_不同的二叉搜索树 {
    public int numTrees(int n) {
        //1.定义dp数组,dp[n]表示n个结点组成的二叉搜索树的数量
        int[] dp = new int[n+1];
        //2.初始化dp数组，dp[i] = dp[i-j] * dp[j-1]
        //当根节点为空的时候，也符合二叉搜索树的结构
        dp[0] = 1;
        //3.遍历，由于后边的二叉树数量依赖于前边的二叉树的数量，所以应该从前往后遍历
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i-j] * dp[j-1];
            }
        }
        return dp[n];
    }
}
