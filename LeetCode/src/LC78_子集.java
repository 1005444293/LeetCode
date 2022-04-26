import java.util.ArrayList;
import java.util.List;

public class LC78_子集 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        //结果中包含空数组，所以应将res放到最上方
        res.add(new ArrayList<>(list));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
