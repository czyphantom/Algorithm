/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 * 题目：给定一个字符串s和一个字符串字典wordDict ，在字符串s中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序返回所有这些可能的句子。
 * 难度：Hard
 * 思路：回溯
 */

// @lc code=start
class Solution {
     public List<String> wordBreak(String s, List<String> wordDict) {
        return backTrace(s, wordDict, new HashMap<String, List<String>>());
    }       
    
    List<String> backTrace(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
            
        List<String> res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = backTrace(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);  
                }
            }
        }       
        map.put(s, res);
        return res;
    }
}
// @lc code=end

