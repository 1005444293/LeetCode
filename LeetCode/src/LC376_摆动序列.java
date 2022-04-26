public class LC376_摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return 1;
        int pre = 0;
        int cur = 0;
        int res = 1;
        for (int i = 0; i < nums.length-1; i++) {
            cur = nums[i+1] - nums[i];
            if ((cur>0 && pre<=0) || (cur<0 && pre>=0)){
                res++;
                pre = cur;
            }
        }
        return res;
    }
}
