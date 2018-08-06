
/**
 * 题目：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        int index = -1;
        for(int i = 0;i < s.length();i++) {
            if(map.get(s.charAt(i)) != null) {
                map.put(s.charAt(i),false);
            } else {
                map.put(s.charAt(i),true);
            }
        }
        for(int i = 0;i < s.length();i++) {
            if(map.get(s.charAt(i)) == true) {
                return i;
            }
        }
        return -1;
    }
}