/**
 * 题目：给定两个字符串s和t，编写一个函数来判断t是否是s的一个字母异位词。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public boolean isAnagram(String s, String t) {
         if (s == null || t == null || s.length() != t.length()) {
             return false;
         }
         Map<Character, Integer> map = new HashMap<Character, Integer>();
         for (char c : s.toCharArray()) {
             map.put(c, map.getOrDefault(c, 0) + 1);
         }
         int missing = s.length();
         for (char c2 : t.toCharArray()) {
             if (!map.containsKey(c2)) {
                 return false;
             }
             map.put(c2, map.get(c2)-1);
             if (map.get(c2) >= 0) {
                 missing--;
             }
         }
         return missing == 0;
 
     }
 }