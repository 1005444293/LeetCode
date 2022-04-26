import java.util.Arrays;

public class LC674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        //1.定义dp数组
        int[] dp = new int[nums.length];
        //2.初始化dp数组，因为每一个元素都会组成长度为1的连续递增子序列，所以每个位置都初始化为1
        Arrays.fill(dp, 1);
        int res = 0;
        //3.遍历
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]){
                dp[i+1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i+1]);
        }
        return res;
    }
}
