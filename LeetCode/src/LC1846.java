import javafx.scene.effect.Blend;

import java.util.Arrays;
import java.util.Map;

/**
 * 减小和重新排列数组后的最大元素:给你一个正整数数组arr 请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * 1.arr 中 第一个 元素必须为 1 。
 * 2.任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length 
 * （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 *
 * 你可以执行以下 2 种操作任意次：
 *
 * 1.减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
 * 2.重新排列 arr 中的元素，你可以以任意顺序重新排列。
 *
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。
 *
 * 输入：arr = [2,2,1,2,1]
 * 输出：2
 * 解释：
 * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
 * arr 中最大元素为 2 。

 */
public class LC1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        //将数组首位赋值为1
        arr[0] = 1;
        //检查数组中元素的大小关系，不符合题目要求的对其进行赋值
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] > 1){
                arr[i+1] = arr[i] + 1;
            }
        }
        //最大值为数组中最后一个元素
        return arr[arr.length - 1];
    }
}
