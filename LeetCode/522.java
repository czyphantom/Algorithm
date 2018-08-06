/**
 * 题目：给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列
 * （即不能是其他字符串的子序列）。
 * 难度：Medium
 * 思路：最长特殊序列只能是字符串本身而不能是子序列。
 */

class Solution {
    public int findLUSlength(String[] strs) {
        int longest = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSub = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSub = false;
                    break;
                }
            }
            if (isSub) longest = Math.max(longest, strs[i].length());
        }
        return longest;
    }

    //判断a是否是b的子串
    public boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) return false;
        if (a.equals(b)) return true;

        int position = 0;

        for (int i = 0; i < b.length(); i++) {
            if (position == a.length()) break;
            if (a.charAt(position) == b.charAt(i)) {
                position++;
            }
        }
        return position == a.length();
    }
}