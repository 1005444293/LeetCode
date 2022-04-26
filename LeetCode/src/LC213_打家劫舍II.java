public class LC213_打家劫舍II {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        //如果所给数组的第一家和最后一家是连着的，此时就需要考虑两种情况
        //1.如果偷了第一家，那么就不能投最后一家，此时将nums的最后一家排除即可
        //2.如果偷了最后一家，那么就不能投第一家，此时排除第一家即可
        int res1 = robRange(nums, 0, nums.length-2);
        int res2 = robRange(nums, 1, nums.length-1);
        return Math.max(res1, res2);
    }

    /**
     * 当前面截取了nums的部分，后续流程与打家劫舍基本相同
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int robRange(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        //1.定义dp数组
        int[] dp = new int[nums.length];
        //2.初始化dp数组
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        //3.遍历
        for (int i = start+2; i <= end ; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
