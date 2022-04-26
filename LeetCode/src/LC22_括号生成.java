import java.util.ArrayList;
import java.util.List;

public class LC22_括号生成 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 0) return res;
        //执行深度优先搜索，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String s, int l, int r, ArrayList<String> res) {
        //递归终止条件，递归终止的时候，将s添加到res中即可
        if (l == 0 && r == 0){
            res.add(s);
            return;
        }
        //剪枝，左括号可以使用的长度大于右括号的个数时，才剪枝
        if (l > r){
            return;
        }

        if (l > 0){
            dfs(s+"(", l-1, r, res);
        }

        if (r > 0){
            dfs(s+")", l, r-1, res);
        }
    }

}
