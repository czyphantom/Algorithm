/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 * 题目：给你一个字符串s ，请你统计并返回这个字符串中回文子串的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 难度：Medium
 * 思路：中心拓展
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), result = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

