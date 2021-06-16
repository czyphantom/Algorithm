/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 * 题目：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 难度：Medium
 * 思路：BFS或DFS
 */

// @lc code=start
class Solution {
    private List<String> result = new ArrayList<>();
    private String[] numMap = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        dfs(digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(String s, int cur, StringBuilder builder) {
        if (cur >= s.length()) {
            result.add(builder.toString());
            return;
        }
        if (s.charAt(cur) >= '2' && s.charAt(cur) <= '9') {
            for (int j = 0;j < numMap[s.charAt(cur)-'1'].length();j++) {
                builder.append(numMap[s.charAt(cur)-'1'].charAt(j));
                dfs(s, cur+1, builder);
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }
}
// @lc code=end

