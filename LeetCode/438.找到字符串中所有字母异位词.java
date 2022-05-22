/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 * 题目：给定两个字符串s和p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 难度：Medium
 * 思路：滑动窗口
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[128];
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        int low = 0, high = 0;
        List<Integer> result = new ArrayList<>();
        while (high < s.length()) {
            if (count[s.charAt(high)] > 0) {
                count[s.charAt(high++)]--;
                if (high - low == p.length()) {
                    result.add(low);
                }
            } else {
                count[s.charAt(low++)]++;
            }
        }
        return result;
    }
}
// @lc code=end

