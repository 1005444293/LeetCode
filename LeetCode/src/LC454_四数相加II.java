import java.util.HashMap;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 思路：此题思路跟两数之和相似，使用map辅助求解，不同的是，两数之和只有一个数组，而此题给了四个数组A\B\C\D，我们将AB视为一组
 *      将CD视为一组，先将AB两个数组的数字排列组合相加，存入map中，key为相加的值，value为该值出现的次数，然后判断（0-C-D）是
 *      否在map中可以找到，如果找到就计数，直至循环结束
 */
public class LC454_四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        if (nums1 == null || nums2 == null || nums3 == null || nums4 == null){
            return res;
        }
        //定义map
        HashMap<Integer, Integer> map = new HashMap<>();
        //将AB看成一组
        for (int a : nums1) {
            for (int b : nums2) {
                if (map.containsKey(a+b)){
                    map.put(a+b, map.get(a+b) + 1);
                }else {
                    map.put(a+b, 1);
                }
            }
        }
        //再将CD看成一组，判断map中是否包含0-c-d，包含的话res就加上0-c-d在map中出现的次数
        for (int c : nums3){
            for (int d : nums4) {
                if (map.containsKey(- c - d)){
                    res += map.get(c + d);
                }
            }
        }
        return res;
    }
}
