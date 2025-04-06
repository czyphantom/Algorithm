/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 * 题目：给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词是由重新排列源单词的所有字母得到的一个新单词。
 * 难度：Medium
 * 思路：异位词可以看作是排序后相同的字符数组，用map存储，key用排序后的字符串即可
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if (!wordMap.containsKey(sortedStr)) {
                wordMap.put(sortedStr, new ArrayList<>());
            }
            wordMap.get(sortedStr).add(str);
        }

        wordMap.values().forEach(list -> result.add(list));
        return result;
    }
}
// @lc code=end

