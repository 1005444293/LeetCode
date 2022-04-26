/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 思路：对于给定的数组nums，对于数组中的任意一个位置 y，我们如何判断它是否可以到达？根据题目的描述，就需要判断在一个索引为x的位置上，
 *      x索引位置的元素为num[x]，那么它可以跳跃的最大长度为x+nums[x]，这个值大于等于y就表明y位置可以到达

 以题目中的示例一
 * [2, 3, 1, 1, 4]
 * 为例：
 * 我们一开始在位置 0，可以跳跃的最大长度为 2，因此最远可以到达的位置被更新为 2；
 * 我们遍历到位置 1，由于 1≤2，因此位置 1 可达。我们用 1 加上它可以跳跃
 * 的最大长度 3，将最远可以到达的位置更新为 4。由于 4 大于等于最后一个位置 4，因此我们直接返回 True。
 *
 *题解链接： https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 *
 */
public class LC55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if (nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i]+i, cover);
            if (cover >= nums.length-1) return true;
        }
        return false;
    }
}
