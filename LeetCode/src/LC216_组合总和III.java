import java.util.ArrayList;
import java.util.List;

public class LC216_组合总和III {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return res;
    }

    private void backTracking(int k, int n, int startIndex, int sum) {
        //第一个if条件判断是剪枝过程，如果总和已经大于目标值n，那么就直接返回
        if (sum > n) return;
        if (list.size() == k){
            if (sum == n){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            list.add(i);
            backTracking(k, n, i+1, sum);
            sum -= i;
            list.remove(list.size()-1);
        }
    }
}
