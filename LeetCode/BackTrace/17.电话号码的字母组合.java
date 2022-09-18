/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 * 题目：给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    private Map<Character,String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTrace(digits, 0, result, new StringBuilder());
        return result;
    }

    private void backTrace(String digits, int cur, List<String> result, StringBuilder curStr) {
        if (cur >= digits.length()) {
            result.add(curStr.toString());
            return;
        }
        String letter = map.get(digits.charAt(cur));
        for (int j = 0;j < letter.length();j++) {
            curStr.append(letter.charAt(j));
            backTrace(digits, cur+1, result, curStr);
            curStr.deleteCharAt(curStr.length()-1);
        } 
    }
}
// @lc code=end

