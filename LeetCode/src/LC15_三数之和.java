import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
            }
        }
        return res;
    }
}
