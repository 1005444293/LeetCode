public class LC135_分发糖果 {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        //给数组中的每一个元素设置初值1
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }
        //从前向后遍历，确定右孩子大于左孩子的情况
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i] < ratings[i+1]){
                res[i+1] = res[i]+1;
            }
        }
        //从后向前遍历，确定左孩子大于右孩子的情况
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1]+1);
            }
        }
        int result = 0;
        for (int i = 0; i < res.length; i++) {
            result += res[i];
        }
        return result;
    }
}
