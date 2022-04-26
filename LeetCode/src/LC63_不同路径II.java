public class LC63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        //1.定义dp数组，dp[i][j]表示从初代点到i，j位置的路线有多少条
        int[][] dp = new int[row][col];
        //2.初始化dp数组，因为有障碍的地方不能继续走，所以初始化的时候要考虑有障碍的地方
        for (int i = 0; i < row && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < col && obstacleGrid[0][i] != 1; i++) {
            dp[0][i] = 1;
        }
        //3.遍历
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //判断此位置是否为1
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }
}
