import java.util.ArrayList;
import java.util.List;

public class LC17_电话号码的组合 {
    String[] letter = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return res;
        }
        backTracking(digits, 0);
        return res;
    }

    private void backTracking(String digits, int index) {
        //递归终止条件
        if (sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String s = letter[digit];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTracking(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
