public class LC123_买卖股票的最佳时间III {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //1.定义dp[][]数组，此题目的dp一共5列，对应
        //0：不操作
        //1：第一次买进
        //2：第一次卖出
        //3：第二次买进
        //4：第二次卖出
        int[][] dp = new int[len][5];
        //2.初始化dp数组
        //第一天不管买进几次，对应的都是当天股票价钱的负值
        //第一天不管卖出几次，手中最大的收益都是0，因为当天买当天卖到最后都是0
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        //遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]+prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3]+prices[i]);
        }
        return dp[len-1][4];
    }
}
