/**
 *
 */
public class LC169_多数元素 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]){
                count++;
            }else {
                count--;
                if (count == 0){
                    res = nums[i+1];
                }
            }
        }
        return res;
    }
}
