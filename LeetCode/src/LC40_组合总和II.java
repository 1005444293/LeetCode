import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_组合总和II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //boolean数组中的数值默认是false
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0, used);
        return res;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        //if (sum < target) return;
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum+candidates[i] <= target; i++) {
            if (i>0 && candidates[i] == candidates[i-1] && used[i-1] == false){
                continue;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            used[i] = true;
            backTracking(candidates, target, sum, i+1, used);
            used[i] = false;
            sum -= candidates[i];
            list.remove(list.size()-1);
        }
    }
}
