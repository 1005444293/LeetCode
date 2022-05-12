import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 思路：①使用哈希表的思想进行解决  题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！可以使用hashset对每轮的结果进行存储，如果
 *      hashset中存在此轮的计算值，那就证明所给数组不是快乐数，反之则为快乐数
 *      ②使用快慢指针的思想进行解决  如果当前数字不是快乐数的话，那么它的计算值会进入循环，那么使用快慢指针，快指针总可以追得上慢指针，
 *      相反，如果快指针一直追不上慢指针的话，就证明当前所给数字是快乐数
 */
public class LC202_快乐数 {
    public boolean isHappy(int n) {
        //首先定义一个hashset
        Set<Integer> res = new HashSet<>();
        //当res中包含某个计算值的时候，证明n就不是快乐数了
        while (n != 1 && !res.contains(n)){
            //将不被res包含的每一轮的n的计算值都添加进res中
            res.add(n);
            n = getNumSum(n);
        }
        //如果n跳出了while循环，且等于1的话，就可以证明n是快乐数
        return  n == 1;
    }

    //对所给数字进行取值计算，即计算每一位上的平方和
    private int getNumSum(int n){
        int sum = 0;
        while (n > 0){
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy3(int n){
        //首先定义快慢指针
        int slow = n;
        int fast = getNumSum(n);
        //快慢指针思想
        while (slow != fast){
            slow = getNumSum(slow);
            fast = getNumSum(getNumSum(fast));
        }
        return slow == 1;
    }
    public boolean isHappy2(int n) {
        int slow = n, fast = getNumSum(n);
        while (slow != fast){
            slow = getNumSum(slow);
            fast = getNumSum(getNumSum(fast));
        };
        return slow == 1;
    }

}
