/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串
 * magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能
 * 在赎金信字符串中使用一次。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * 思路：此题与242有相似之处，暴力解法使用双层for循环，对所给字符串进行逐个字符的比较，而使用哈希法可以简化求解
 *      哈希法：因假设所给字符串中只含有小写字母，所以可以定义长度为26的数组，将magazine中的每个字符按照ASCII
 *      码进行存储，然后再对ransom中的字符进行比对，如果ransom中的字符在数组中都能找到，那么就返回true，否则
 *      返回false
 *
 */
public class LC383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] num = new int[26];
        //将magazine中的字符存储到num数组中
        for (char c : magazine.toCharArray()) {
            int tmp = c - 'a';
            num[tmp]++;
        }
        //对ransomNote中的字符进行逐个比对
        for (char c : ransomNote.toCharArray()) {
            int tmp = c - 'a';
            if (num[tmp] > 0){
                num[tmp]--;
            }else{
                return false;
            }
        }
        return true;
    }
}
