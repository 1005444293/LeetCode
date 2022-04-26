/**
 *思路：从所给二维矩阵的左下角开始，如果当前元素等于target，那么直接返回true
 *      如果当前元素大于target，那么向上挪动一行，列不变，即matrix[i][j]变为matrix[i-1][j]
 *      如果当前元素小于target，那么向右挪动一列，行不变，即matrix[i][j]变为matrix[i][j+1]
 *      https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-iicong-ju-zhen-de-ktzv/
 */
public class LC540_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
