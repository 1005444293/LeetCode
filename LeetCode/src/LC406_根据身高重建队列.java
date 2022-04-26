import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 根据身高重建队列
   解题思路：先排序再插入
 * 1.排序规则：按照先H高度降序，K个数升序排序
 * 2.遍历排序后的数组，根据K插入到K的位置上
 */
public class LC406_根据身高重建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        //先对所给数组进行排序，然后将排好序的数组按照k的值进行插入
        //1.排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        //2.对排好序的数组按照k的值依次插入到队列里
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] tmp : people) {
            res.add(tmp[1], tmp);
        }
        return res.toArray(people);
    }
}
