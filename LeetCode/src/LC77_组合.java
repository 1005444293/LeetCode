import java.util.ArrayList;
import java.util.List;

public class LC77_组合 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }

    private static void backTracking(int n, int k, int startIndex) {
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        //i<=n 可以优化为 i<=n-(k-list.size())+1
        //解释：例如n=4，k=4，当i为2、3时，都没有必要再进行递归和回溯了，因为数字已经不能够满足解题条件了
        for (int i = startIndex; i <= n; i++){
            list.add(i);//处理节点
            backTracking(n, k, i+1);
            list.remove(list.size()-1);//回溯
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> r = combine(n,k);
    }
}
