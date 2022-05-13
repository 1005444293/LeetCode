import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * 思路：①可以使用暴力求解，即双层for循环，外层循环从下标为i的数开始，内层从i+1的数开始，如果两个数的和等于target，则返回二者下标
 *      ②使用map进行求解，首先需要一个for循环，使用target-nums[i]，判断map中是否存在和target-nums[i]相等的值，存在就证明找到了
 *      不存在就将当前nums[i]放入map中，当找到合适的值时，输出二者下标
 */
public class LC1_两数之和 {
    //使用方法②
    public int[] twoSum(int[] nums, int target) {
        //首先对nums进行判断
        if (nums.length == 0 || nums == null){
            return new int[0];
        }
        //定义map
        HashMap<Integer, Integer> map = new HashMap<>();
        //开始循环
        for (int i = 0; i < nums.length; i++) {
            //如果当前map中包含target - nums[i]，证明已经找到结果
            if (map.containsKey(target - nums[i])){
                Integer index = map.get(target - nums[i]);
                return new int[]{index, i};
            }
            //如果没有找到，就将当前值和其对应的索引放入map中
            map.put(nums[i], i);
        }
        return new int[0];
    }

    //使用方法①
    public int[] twoSum2(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            return new int[0];
        }
        //开启双层for循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
