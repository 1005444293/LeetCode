/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 *
 * 思路：本题要坚持循环不变量原则，即坚持左闭右开或左闭右闭原则，由于最后要形成正方形矩阵，每条边需要填充数字的数量是一致的，所以使用左闭
 *      右开原则更适合，以n=3为例，使用左闭右开原则进行填充数字，从(0,0)位置填充，第一行从左至右，最右列从上到下，第三行从右到左，最左列
 *      从下到上，每次填充2个位置，由外圈向内圈一圈一圈画下去
 */
public class LC59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        //定义二维数组
        int[][] res = new int[n][n];
        //循环次数
        int loop = n / 2;
        //第一次循环填充的位置
        int startX = 0;
        int startY = 0;
        //填充的数字，后续每填充一个位置，都对其进行累加
        int count = 0;
        //每一圈循环，都需要控制每一条边填充的长度
        int offset = 1;
        //每圈循环的起始位置
        int i, j;
        //中间位置
        int mid = n / 2;
        //每循环一圈，loop--
        while (loop > 0){
            i = startX;
            j = startY;
            //最上面一行填充
            for (; j < startY + n - offset; j++) {
                res[i][j] = count++;
            }
            //最右侧一列填充
            for (; i < startX + n - offset; i++){
                res[i][j] = count++;
            }
            //最下面一行填充
            for (; j > startY; j--){
                res[i][j] = count++;
            }
            //最左侧一列填充
            for(; i > startX; i--){
                res[i][j] = count++;
            }
            //循环一圈后，loop--
            loop--;
            //下一次循环从上一轮循环的右下方开始
            startX++;
            startY++;
            //控制每一轮循环中每一条边的长度
            offset += 2;
        }
        //当n为奇数时，针对正方形正中间的那个位置进行填充
        if (n % 2 == 1){
            res[mid][mid] = count;
        }
        return res;
    }
}
