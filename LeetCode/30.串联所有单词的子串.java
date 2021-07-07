/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 * 题目：给定一个字符串s和一些长度相同的单词words 。找出s中恰好可以由words中所有单词串联形成的子串的起始位置。
 * 注意子串要与words中的单词完全匹配，中间不能有其他字符 ，但不需要考虑words中单词串联的顺序。
 * 难度：Hard
 * 思路：遍历，用map存储每个字符串出现的次数
 */

// @lc code=start
class Solution {
   public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int len = words[0].length();

        Map<String, Integer> wordsMap = new TreeMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.containsKey(word) ? wordsMap.get(word) + 1 : 1);
        }
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new TreeMap<String, Integer>(wordsMap);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j*len, i + j*len + len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) {
                        copy.remove(str);
                    } else {
                        copy.put(str, count - 1);
                    }
                    if (copy.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
// @lc code=end

