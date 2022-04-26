import java.util.*;

/**
 * 字母异位词分组:给定一个字符串数组，将字母异位词组合在一起。可以按
 * 任意顺序返回结果列表。字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 思路：1.对每个字符串组成的字符数组进行排序，如果其组成字符相同，那么其排序后的结果也是相同的
 *      2.利用hashmap将排好序的字符串作为key，将未排序的该字符串作为value
 *      3.将hashmap中的value值赋给一个新的集合返回即可
 */
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //如果字符串数组为空
        if (strs == null || strs.length == 0) return new ArrayList<>();
        //创建一个Hash表
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            //将str转换成字符数组，以便排序
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            //判断hash表中是否含有key，不存在的话就将其添加进hash表
            if (!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            //将对应的str值添加进hash表中
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
