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
    private String[] numMap = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTrace(digits, 0, result, new StringBuilder());
        return result;
    }

    private void backTrace(String digits, int cur, List<String> result, StringBuilder builder) {
        if (cur >= digits.length()) {
            result.add(builder.toString());
            return;
        }
        String curString = numMap[digits.charAt(cur)-'0'-2];
        for (int j = 0;j < curString.length();j++) {
            builder.append(curString.charAt(j));
            backTrace(digits, cur+1, result, builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
// @lc code=end

