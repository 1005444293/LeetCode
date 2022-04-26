public class LC738_单调递增的数字 {
    public static int monotoneIncreasingDigits(int n) {
        //将所给整数转换成字符数组
        char[] str = String.valueOf(n).toCharArray();
        //设置标志位，用于寻找第一个逆序对的数字位置
        int i = 1;
        //寻找第一个逆序对的数字位置
        while (i < str.length && str[i-1] <= str[i]){
            i++;
        }
        if (i < str.length){
            //将第一个为逆序对的数字自减1，其后边的数字都设置为9
            while (i > 0 && str[i-1] > str[i]){
                str[i-1]--;
                i--;
            }
            //此for循环的作用便是将第一个逆序位置后边的数字都给成9
            for (i += 1; i < str.length; i++) {
                str[i] = '9';
            }
        }
        return Integer.parseInt(new String(str));
    }

    public static void main(String[] args) {
        int n = 54321;
        int res = monotoneIncreasingDigits(n);
        System.out.println(res);
    }
}
