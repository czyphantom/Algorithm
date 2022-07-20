/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 * 题目：给你一个字符串s，请你将s分割成一些子串，使每个子串都是回文串 。返回s所有可能的分割方案。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrace(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrace(String s, int cur, List<String> temp, List<List<String>> result) {
        if (cur >= s.length() && temp.size() != 0) {
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = cur;i < s.length();i++) {
            if (isPalindrome(s, cur, i)) {
                temp.add(s.substring(cur, i+1));
                backTrace(s, i+1, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }
}
// @lc code=end

