public class LC45_跳跃游戏II {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int res=0, curJump=0, nextJump=0;
        for (int i = 0; i < nums.length; i++) {
            nextJump = Math.max(nextJump, i+nums[i]);
            if (i == curJump){
                if (curJump != nums.length-1){
                    res++;
                    curJump = nextJump;
                    if (nextJump >= nums.length-1){
                        break;
                    }
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
