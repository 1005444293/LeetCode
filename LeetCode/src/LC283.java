/**
 * 移动零：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class LC283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        //第一次遍历将不为0的数挪到数组的前面，其余的位置就都是0
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        //第二次遍历将剩余的位置都补上0即可
        for(int i=j; i<nums.length; i++){
            nums[i] = 0;
        }
    }


}
