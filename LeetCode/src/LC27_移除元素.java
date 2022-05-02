/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 思路：①暴力解法：因为数组在内存中的存储地址是连续的，所以对于要移除的元素不能直接删除，而是要后面的元素覆盖前面的元素，保证存储地址的
 *      连续性，暴力解法可以使用两个for循环，外层for循环负责遍历数组，内层for循环负责更新数组元素
 *
 *      ②双指针法：利用快慢指针和单层for循环实现双层for循环的效果，当快慢指针指向第一个元素时，如果此元素与目标值不相同，则快慢指针均+1，
 *      如果当前元素与目标值相同，则快指针+1，然后快指针将其指向的元素赋值给慢指针指向的元素，然后二者再分别+1
 *
 */
public class LC27_移除元素 {
    /**
     * 暴力解法
     * @param nums 所给数组
     * @param val 目标值
     * @return 返回删除目标值的数组长度
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]){
                //将j指向i+1元素的位置，便于后续覆盖元素
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j-1] = nums[j];
                }
                //覆盖完元素，原来i位置上的元素变成了原来i+1位置上的元素，因为不知道i+1位置上的元素是否与val相等，所以i--
                i--;
                //相应的length也要减一，因为少了一个元素
                length--;
            }
        }
        return length;
    }

    /**
     * 双指针法
     * @param nums 所给数组
     * @param val 目标值
     * @return 返回删除目标值的数组长度
     */
    public int removeElement1(int[] nums, int val) {
        //快慢指针
        int fastIndex = 0;
        int slowIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]){
                //为了处理所给数组第一个元素就是目标元素的情况，使用fastIndex指针对应的元素覆盖slowIndex指针对应的元素
                //例如nums=[3, 2, 2, 3]，val = 3的情况
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
