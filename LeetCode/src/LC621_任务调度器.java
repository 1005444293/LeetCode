import java.util.Arrays;

/**
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 * 题解思路： https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
 */
public class LC621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        //用于存储26个英文字母的数组，按照顺序存储
        int[] buckets = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i] - 'A']++;
        }
        //将tasks中元素出现的次数按照升序排列
        Arrays.sort(buckets);
        //如果task数组中元素足够多，会将buckets排满
        //那么buckets数组中最后的元素的数值最大，即tasks出现次数最多的元素
        int maxTimes = buckets[25];
        int maxCount = 1;
        int res = 0;
        for (int i = 25; i >= 1 ; i--) {
            //如果有次数相同的任务，那么maxCount++
            if (buckets[i] == buckets[i-1]){
                maxCount++;
            }else {
                break;
            }
        }
        res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
