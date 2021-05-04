/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * 题目：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 难度：Medium
 * 思路：采用滑动窗口的思想，出现重复字符时，将窗口的开始移动到重复的字符上次出现的位置后一位。
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int begin = 0;
        int end = begin+1;
        int max = 1;
        int len = s.length()-1;
        //存放字符和它前一次出现的位置
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(begin), begin);
        while (end <= len) {
            if (map.get(s.charAt(end)) == null || map.get(s.charAt(end)) < begin) {
                max = Math.max(max, end-begin+1);
            } else {
                begin = map.get(s.charAt(end))+1;
            }
            map.put(s.charAt(end), end);
            end++;
        }
        return max;
    }
}
// @lc code=end

