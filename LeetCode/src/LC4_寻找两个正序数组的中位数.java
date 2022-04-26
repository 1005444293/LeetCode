/**
 *
 */
public class LC4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        double res = 0.0;
        int[] temp = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                temp[k++] = nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }
        while (i < nums1.length){
            temp[k++] = nums1[i++];
        }
        while (j < nums2.length){
            temp[k++] = nums2[j++];
        }
        if (temp.length % 2 == 1){
            res = (double) temp[temp.length/2];
        }else {
            res = (double) ((temp[temp.length/2] + temp[temp.length/2-1]) / 2.0);
        }
        return res;
    }
}








