/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 * 题目：给定两个字符串s和t ，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 难度：Easy
 * 思路：Map
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0;i < s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
            if (reverseMap.containsKey(t.charAt(i))) {
                if (reverseMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                reverseMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
// @lc code=end

