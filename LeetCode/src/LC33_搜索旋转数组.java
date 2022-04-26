/**
 *思路:二分查找，两个指针i，j，分别从数组前后同时进行查找
 */
public class LC33_搜索旋转数组 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int res = -1;
        while (i <= j){
            if (nums[i] == target){
                res = i;
                break;
            }
            i++;
            if (nums[j] == target){
                res = j;
                break;
            }
            j--;
        }
        return res;
    }
}
