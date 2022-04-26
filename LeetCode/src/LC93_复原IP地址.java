import java.util.ArrayList;
import java.util.List;

public class LC93_复原IP地址 {
    List<String> res = new ArrayList<>();//用于记录最终结果
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;//如果s的长度大于12，证明就不是网络中的有效ip地址
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        backTracking(sb,0,0);
        return res;
    }

    private void backTracking(StringBuilder sb, int startIndex, int pointNum) {
        if (pointNum == 3){
            if (isValid(sb,startIndex,sb.length()-1)){
                res.add(sb.toString());
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb, startIndex, i)){
                sb.insert(i+1, '.');//在对应位置插入'.'
                pointNum++;
                backTracking(sb, i+2, pointNum);
                pointNum--;
                sb.deleteCharAt(i+1);//回溯
            }else {
                break;
            }
        }
    }

    private boolean isValid(StringBuilder sb, int start, int end) {
        if (start > end) return false;
        if (sb.charAt(start) == 0 && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (sb.charAt(i) > '9' || sb.charAt(i) < '0'){
                return false;
            }

            num = num * 10 + (sb.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }
}
