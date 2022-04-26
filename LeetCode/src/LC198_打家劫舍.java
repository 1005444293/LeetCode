public class LC198_打家劫舍 {
    public int rob(int[] nums) {
        //判断所给数组长度小于2的话，可以直接返回
        if (nums.length < 2) return nums[0];
        //1.定义dp数组，dp[i]表示下标i以内的房屋可以偷窃到的最高金额
        int[] dp = new int[nums.length];
        //2.初始化dp数组，决定dp[i]大小的关键因素是偷不偷第i个房间
        //如果偷窃第i个房屋，那么dp[i] = dp[i-2]+nums[i]
        //如果不偷第i个房间，那么dp[i] = dp[i-1]
        //所以初始化，就是看dp[0]和dp[1]，而dp[0]取决于nums[0]，dp[1]取决于nums[0]和nums[1]那个大
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //3.遍历，遍历顺序显然是从前往后遍历
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
