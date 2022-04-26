import java.util.ArrayList;
import java.util.List;

public class LC763_划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() == 0) return res;
        //哈希表，存放a-z字母出现的次数
        int[] hash = new int[27];
        //遍历所给字符串，统计每个字符出现最右边界
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right){
                res.add(right-left+1);
                left = i + i;
            }
        }
        return res;
    }
}
