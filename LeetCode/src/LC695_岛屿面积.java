public class LC695_岛屿面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    int area = area(grid, i, j);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    private int area(int[][] grid, int i, int j) {
        if (!(i < grid.length && i>=0 && j < grid[0].length && j >= 0)){
            return 0;
        }
        if (grid[i][j] != 1){
            return 0;
        }
        //将走过的位置设置为2
        grid[i][j] = 2;
        //继续遍历，找到最大面积
        return 1+
                area(grid, i, j+1) +
                area(grid, i+1, j) +
                area(grid, i, j-1) +
                area(grid, i-1, j);
    }
}
