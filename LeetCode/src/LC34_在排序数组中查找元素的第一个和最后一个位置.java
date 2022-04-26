/**
 *
 */
public class LC34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int i = -1;
        int j = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == target){
                i = k;
                break;
            }
        }
        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] == target){
                j = k;
                break;
            }
        }
        res[0] = i;
        res[1] = j;
        return res;
    }
}
