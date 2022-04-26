public class LC309_最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //1.定义dp数组，根据题意可以得出四种状态
        //状态一：买入股票状态（可以是今天买入的股票，也可以是之前就买入股票然后一直没操作）
        //状态二：卖出股票状态，两天前就卖出股票，度过了冷冻期，一直没操作，今天依旧保持卖出股票的状态
        //状态三：卖出股票状态，今天刚卖出股票
        //状态四：今天为冷冻期状态，但是冷冻期只持续一天
        int[][] dp = new int[len][4];
        //2.初始化dp数组
        //只有状态一初始化为-prices[0]，其他三种状态在第一天都是不能存在的
        dp[0][0] = -prices[0];
        //3.遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][3], dp[i-1][1])-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        return Math.max(Math.max(dp[len-1][1], dp[len-1][2]), dp[len-1][3]);
    }
}
