import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LC56_合并区间 {
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return new int[0][];
        //对所给数组排序，按照升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //设置一个标志位，用于判断最后一个数组是否也被合并了
        boolean flag = false;
        int len = intervals.length;
        //从前向后遍历，每次用start和end记录此次的左右边界
        for (int i = 1; i < len; i++) {
            int start = intervals[i-1][0];
            int end = intervals[i-1][1];
            //如果索引为i的数组与i-1数组重合，那么更新右边界的值用于合并两个数组
            while (i < len && end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
                //如果i == len - 1，那么证明所有的数组都被合并了，
                // 用标志位flag记录，避免下面重复添加最后一个数组
                if (i == len - 1) flag = true;
                i++;
            }
            res.add(new int[]{start, end});
        }
        //如果flag == false就表明最后一个数组没有被合并，需要将其添加进结果集中
        if (flag == false){
            res.add(new int[]{intervals[len-1][0], intervals[len-1][1]});
        }
        //Arraylist与数组之间相互转换
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(arr);
        for (int[] r:res) {
            System.out.println(r);
        }
    }
}
