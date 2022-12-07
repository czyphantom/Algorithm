/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 * 题目：给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 难度：Medium
 * 思路：对每个字符串的字符进行排序，得到标准字符串，放到Map里保存。
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String standartStr = toAnagrams(str);
            if (map.containsKey(standartStr)) {
                map.get(standartStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                map.put(standartStr, list);
            }
        }
        return result;
    }

    private String toAnagrams(String a) {
        char[] aArray = a.toCharArray();
        Arrays.sort(aArray);
        return new String(aArray);
    }
}
// @lc code=end

