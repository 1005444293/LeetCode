import java.util.ArrayList;
import java.util.List;

public class LC46_全排列 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, int[] used) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1){
                continue;
            }
            used[i] = 1;
            list.add(nums[i]);
            backTracking(nums, used);
            list.remove(list.size()-1);
            used[i] = 0;
        }
    }
}
