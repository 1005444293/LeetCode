import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47_全排列II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            if (used[i] == false){
                list.add(nums[i]);
                used[i] = true;
                backTracking(nums, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
