import java.util.ArrayList;
import java.util.List;

public class LC39_组合总数 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0){
            return res;
        }
        backTracking(candidates, target, 0, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex) {
        //递归终止条件
        if (sum > target) return;
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        //&& sum+candidates[i] <= target叫做剪枝操作，保证sum+candidates[i] <= target后续的遍历和递归才有意义
        for (int i = startIndex; i <= candidates.length-1 && sum+candidates[i] <= target; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            list.remove(list.size()-1);
        }
    }
}
