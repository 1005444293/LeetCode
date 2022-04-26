public class LC_53最大子序和 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > res) res = count;
            if (count <= 0) count = 0;
        }
        return res;
    }
}
