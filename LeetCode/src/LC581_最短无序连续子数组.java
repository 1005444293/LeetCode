import java.util.Arrays;

/**
 * 思路一：既然是让寻找最短无序连续子数组，那么我们可以将所给数组复制一份，然后将其排序，在用双指针分别从数组的头和尾进行比对
 *        当双指针所对应的不一样的元素的两个索引范围内的子数组的大小便是要输出的答案
 *
 * 题解链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-e1le/
 */
public class LC581_最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int i = 0;
        int j = temp.length - 1;
        while (i < j && temp[i] == nums[i]){
            i++;
        }
        while (i < j && temp[j] == nums[j]){
            j--;
        }
        return (j-i+1);
    }
}
