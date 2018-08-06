/**
 * 题目：给出n代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 难度：Medium
 * 思路：递归
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, n, "", result);
        return result;
    }

    private void solve(int left, int right, String path, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(path);
            return;
        }
        //剩余左括号数大于右括号数，直接返回
        if (left > right) {
            return;
        }
        if (left != 0) {
            solve(left - 1, right, path + "(", result);
        }
        if (right != 0 && right > left) {
            solve(left, right - 1, path + ")", result);
        }
    }
}