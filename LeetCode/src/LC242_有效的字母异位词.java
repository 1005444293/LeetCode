/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 *
 * 思路：可以使用哈希表的思想，构造哈希函数，将所给字符串的字符映射到一个哈希表中，再进行判断
 *      例如：构造一个长度为26的数组，所给字符串中的字符是从a-z的小写字母，所以可以将每一个字符自动减去a的ASCII码大小，记录在对应
 *      数组的索引位置处，然后让另一个字符串中的字符也减去a的ACSII码值，去对数组中已经存在的记录进行相抵消，如果最后数组中所有的索引
 *      处对应的值都是0的话就证明两个字符串是字母异位词，否则就不是
 */
public class LC242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        //首先建立长度为26的数组作为哈希表
        int[] record = new int[26];
        //对s中的字符进行映射
        for (char schar : s.toCharArray()) {
            record[schar - 'a']++;
        }
        //对t中的字符进行映射
        for (char tchar : t.toCharArray()) {
            record[tchar - 'a']--;
        }
        //遍历record数组，查看是否全为0
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0){
                return false;
            }
        }
        return true;
    }
}
