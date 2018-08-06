/**
 * 题目：给定一个赎金信(ransom)字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串
 * magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}