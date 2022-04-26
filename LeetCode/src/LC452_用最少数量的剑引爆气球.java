import java.util.Arrays;
import java.util.Comparator;

public class LC452_用最少数量的剑引爆气球 {
    public static int findMinArrowShots(int[][] points) {
        //1.只要所给数组不为空，那么最少需要一支箭
        if (points.length == 0) return 0;
        int res = 1;
        //2.对所给数组进行排序，可以按照索引为0的位置排序，也可以按照索引为1的位置排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /**
                 * 如果返回 1  说明o1 > o2  如 2  1
                 * 如果返回 0  说明o1 = o2   如 cc  cc
                 * 如果返回 -1 说明o1 < o2   如 6  7
                 */
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        //3.对排完序的数组进行遍历
        for (int i = 1; i < points.length; i++) {
            //相邻的两个气球没有挨在一起，需要一支箭
            if (points[i-1][1] < points[i][0]){
                res++;
            }else{
                //相邻的两个气球挨在一起，更新最小右边界
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int res = findMinArrowShots(points);
        System.out.println(res);
    }
}
