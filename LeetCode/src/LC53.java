/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 思路：设置计数变量res，遍历数组，如果与target值相等，res++
 */
public class LC53 {
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                res++;
            }
        }
        return res;
    }
}
