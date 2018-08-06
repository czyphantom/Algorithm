/**
 * 题目：给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 难度：Medium
 * 思路：双指针+哈希表，用两个指针分别保存子串的开始位置和结束位置，另外用一个Map保存每个字符上一次出现的位置。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int begin = 0,end = 0;
        int result = 0;
        while (end < s.length()) {
            if(map.get(s.charAt(end)) == null) {
                map.put(s.charAt(end),end);
                end++;
            } else {
                if (map.get(s.charAt(end)) < begin) {
                    map.put(s.charAt(end),end);
                    end++;
                } else if (map.get(s.charAt(end)) == begin) {
                    map.put(s.charAt(end),end);
                    begin++;
                    end++;
                } else {
                    begin = map.get(s.charAt(end))+1;
                    map.put(s.charAt(end),end);
                    end++;
                }
            }
            result = Math.max(end - begin,result);
        }
        return result;
    }
}