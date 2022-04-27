/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的
 * 长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 思路：①暴力解法：双层for循环寻找符合条件的子序列，使用sum和len记录当前循环内的元素之和与元素个数，使用res记录当前
 * 所有符合条件的最短数组的长度，两层for循环分别从所给数组的第一个元素开始
 *      ②滑动窗口法：也可叫做双指针法，i，j两个指针，分别从所给数组的第一个元素开始，开启一个for循环，j向前移动，sum
 *      记录i和j之间的元素之和，当sum>=s时，sunLen和res分别记录当前元素个数和min(j-i+1)，随后i向前移动，一直到for
 *      循环结束，这样将暴力解法时间复杂度的O(n^2)降低至O(n)
 */
public class LC209_长度最小的子数组 {

    public int minSubArrayLen1(int[] nums, int s){
        //定义结果res，先设置为最大值
        int res = Integer.MAX_VALUE;
        //记录子序列元素之和
        int sum = 0;
        //记录子序列的长度
        int subLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                //如果当前sum记录的元素之和大于等于s时，便可以记录当前的元素信息了
                if (sum >= s){
                    subLen = j - i + 1;
                    res = res > subLen ? subLen : res;
                    //因为是寻找符合条件的最短子序列，所以找到后就break，开始下一轮寻找
                    break;
                }
            }
        }
        return res = res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen2(int[] nums, int s){
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int subLen = 0;
        int  i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= s){
                subLen = j - i + 1;
                res = res < subLen ? res : subLen;
                //当指针i，j之间的元素之和不满足while循环条件时，删除sum中记录的num[i]，并将i指针向前移动一位
                //这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
                sum -= nums[i++];
            }
        }
        return res = res == Integer.MAX_VALUE ? 0 : res;
    }
}
