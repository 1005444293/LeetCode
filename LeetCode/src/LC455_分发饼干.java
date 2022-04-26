import java.util.Arrays;

public class LC455_分发饼干 {
    /**
     *
     * @param g 孩子的胃口数组
     * @param s 饼干数组
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int res = 0;
        for (int i = g.length-1; i >= 0 ; i++) {
            if (index >= 0 && s[index] >= g[i]){
                res++;
                index--;
            }
        }
        return res;
    }
}
