/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 * 题目：给定一个非空字符串s和一个包含非空单词的列表wordDict，判定s是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 拆分时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 * 难度：Medium
 * 思路：动态规划，dp[i] = dp[0~i-1] && substring(j,i)
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1;i <= s.length();i++) {
            for (int j = 0;j < i;j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end