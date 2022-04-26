import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1005_K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //本体使用的优先队列，默认按照升序将入队元素进行排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        //将所给元素依次入队，并用sum记录此时各元素的和
        for (int num:nums) {
            queue.add(num);
            sum += num;
        }
        //将元素按照从小到大的顺序取反k次
        for (int i = 0; i < k; i++) {
            Integer tmp = queue.poll();
            //元素和减二倍的tmp值
            sum -= 2*tmp;
            //考虑到k数值可能大于nums.length，所以将上面出队的元素再次入队
            queue.add(-tmp);
        }
        return sum;
    }
}
