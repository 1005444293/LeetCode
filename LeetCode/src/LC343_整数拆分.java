public class LC343_整数拆分 {
    public int integerBreak(int n) {
        //1.定义dp[]数组，dp[i]表示拆分整数n对应的最大乘积
        int[] dp = new int[n+1];
        //2.初始化dp[]数组,因为dp[0]和dp[1]没有拆分的实际意义
        //所以从dp[2]开始初始化
        dp[2] = 1;
        //3.遍历，dp数组中，索引值大的结果与前面索引值小的有关，所以从前向后遍历
        //j的取值范围为1-(i-1)，因为j是拆解的i的两个数字中的一个，不能超过i的大小
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i-1; j++) {
                //从1遍历到n，有两种方式获得dp[i]
                //1.dp[i] = j*(i-j)
                //2.dp[i] = j*dp[i-j],dp[i-j]表示拆分i-j对应的最大乘积
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
