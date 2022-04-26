import java.util.concurrent.ConcurrentHashMap;

public class LC62_不同路径 {

//    public int uniquePaths(int m, int n) {
//        return dfs(1, 1, m, n);
//    }
//
//    private int dfs(int i, int j, int m, int n) {
//        if (i > m || j > n) return 0;
//        if (i == m && j == n) return 1;
//        return dfs(i+1, j, m , n) + dfs(i, j+1, m, n);
//    }

    public int uniquePaths(int m, int n) {
        //1.创建dp数组
        int[][] dp = new int[m][n];
        //2.推导递推公式
        //3.dp数组初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //4.确定遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map= new ConcurrentHashMap<>();

    }
}
