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
        int[] map = new int[26];
        for (int i = 0;i < p.length();i++) {
            map[p.charAt(i)-'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int low = 0, high = 0;
        while (high < s.length()) {
            if (map[s.charAt(high)-'a'] > 0) {
                map[s.charAt(high++)-'a']--;
                if (high - low == p.length()) {
                    result.add(low);
                }
            } else {
                //出现没有过的字母，增加计数，下次high也会消费掉
                 map[s.charAt(low++)-'a']++;
            }
        }
        return result;
    }
}
// @lc code=end

