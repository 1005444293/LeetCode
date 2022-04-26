public class LC714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        //1.定义dp数组，dp[i][0]和dp[i][1]分别表示第i天持有股票和不持有股票手中所获的最大利润
        int[][] dp = new int[len][2];
        //2.初始化dp数组
        //第一天不持有股票，就是0，而持有股票就是第一天买入股票，即减去当天的股票价格
        dp[0][0] = -prices[0];
        //3.遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]-fee);
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
}
