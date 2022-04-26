public class LC121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        //1.定义dp数组
        int len = prices.length;
        int[][] dp = new int[len][2];
        //2.初始化dp数组
        //dp[i][0]为第i天持有股票时手中的现金(此时可以是之前已经买进，也可以是今天刚刚买入)
        //dp[i][1]为第i天不持有股票时手中的现金(此时可以是之前已经卖出，也可以是今天刚刚卖出)
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            //dp[i][0]，此时手中的现金可以由昨天持有股票，今天保持现状得来，也可以刚刚买入后手中的现金数得来
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            //dp[i][0]，此时手中的现金可以由昨天不持有股票，今天依旧不持有股票的状态得来，也可以由今天刚刚卖出的状态得来
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[len-1][1];
    }
}


