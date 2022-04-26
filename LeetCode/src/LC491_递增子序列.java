import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC491_递增子序列 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (list.size() > 1){
            res.add(new ArrayList<>(list));
        }
        int[] used = new int[nums.length];
        for (int i = startIndex; i < nums.length; i++) {
            if ((!list.isEmpty() && nums[i] < list.get(list.size()-1)) || used[nums[i]+100] == 1){
                continue;
            }
            used[nums[i]+100] = 1;
            list.add(nums[i]);
            backTracking(nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
