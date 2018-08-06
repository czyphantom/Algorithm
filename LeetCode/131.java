/**
 * 题目：给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。返回s所有可能的分割方案。
 * 难度：Medium
 * 思路：回溯
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        solve(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void solve(String s, int begin, List<String> temp, List<List<String>> result) {
        if (begin == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            if (isMatch(s, begin, i)) {
                temp.add(s.substring(begin, i + 1));
                solve(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isMatch(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            } 
        }   
        return true;
    }
}