import java.util.ArrayList;
import java.util.List;

public class LC131_分割回文串 {
    static List<List<String>> res = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String s = "aab";
        partition(s);

    }

    private static List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    private static void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()){
            res.add(list);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPail(s, startIndex, i)){
                //如果判断s中的startIndex到i的字符是回文子串，就将其添加到list中
                list.add(s.substring(startIndex, i+1));
            }else{
                continue;
            }
            backTracking(s,i+1);
            list.remove(list.size()-1);
        }
    }

    private static boolean isPail(String s, int start, int end) {
        for (int i=start, j=end; i<j; i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
