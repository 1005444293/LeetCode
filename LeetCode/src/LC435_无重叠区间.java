import java.util.Arrays;
import java.util.Comparator;

public class LC435_无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        //只要数组长度不为零，那么最少有一个无重叠的区间
        int res = 1;
        //1.将所给数组按照每一个元素的有边界升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //2.从左向右遍历，找出不重叠的区间
        int tmp = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果intervals[i]的左边界大于tmp，表示找到了不与目前区间重叠的下一个区间
            //将此区间的有边界赋给tmp变量，并将结果自增1
            if (intervals[i][0] > tmp){
                tmp = intervals[i][1];
                res++;
            }
        }
        //需要删除的区间的数量即为所给二维数组的长度减去区间不重叠的数量
        return intervals.length - res;
    }
}
