/**
 * 盛最多水的容器：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 *思路：利用双指针从数组的左右两边开始，依次比较左右指针对应的坐标的值的大小，
 *      左边小的话用max记录此时的容器的容量值，然后指针右移
 *      右边小的话用max记录此时的容器的容量值，然后指针左移
 *复习过1次
 */
public class LC11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right){
            max = height[left] < height[right] ?
                    Math.max(max, (right - left) * height[left++]) :
                    Math.max(max, (right - left) * height[right--]);
        }
        return max;
    }
}
