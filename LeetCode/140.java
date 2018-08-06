/**
 * 题目：给定一个非空字符串s和一个包含非空单词列表的字典wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。字典单词可以重复利用。
 * 难度：Hard
 * 思路：dfs
 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       
    
    List<String> dfs(String s, List<String> wordDict, Map<String, LinkedList<String>> map) {
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
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);  
                }             
            }
        }       
        map.put(s, res);
        return res;
    }
}