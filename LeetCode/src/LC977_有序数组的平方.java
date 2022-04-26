/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 思路：所给数组其实是有序的，只不过因为有些负数平方过后变得比其他的数还要打
 *      那么数组平方后的最大值就是在数组的两端，不是左边就是右边，此时可以考虑
 *      使用双指针法，使用i指向数组左端，j指向数组右端，同时创建一个与所给数组A
 *      相同大小的数组B，设置标志位index指向此数组的终止位置。例如A[i]*A[i]<
 *      A[j]*A[j]的话，就让B[index--] = A[j]*A[j]
 */
public class LC977_有序数组的平方 {
    public static int[] sortedSquares(int[] nums) {
        //设置左右指针分别指向所给数组的左右两端
        int right = nums.length - 1;
        int left = 0;
        //创建新的数组，与所给数组长度相同
        int[] result = new int[nums.length];
        //设置指针index指向创建数组的右端，便于记录数值
        int index = result.length - 1;
        //循环条件：左指针小于等于右指针的索引位置
        while (left <= right) {
            //如果左端元素平方后的值大于右端元素平方后的值，则result数组记录左边元素平方后的值
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                //反之亦然
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-4,-1,0,3,10};
        int[] ints = sortedSquares(nums);
        for (int res : ints) {
            System.out.println(res);
        }
    }
}
