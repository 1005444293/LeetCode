public class LC122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //1.定义dp[][]数组，dp[i][0]表示第i天持有股票获得的最大收益，dp[i][1]表示第i天不持有股票获得的最大收益
        int[][] dp = new int[len][2];
        //2.初始化dp数组
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }
        return dp[len-1][1];
    }
}
