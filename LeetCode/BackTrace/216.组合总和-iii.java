/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 * 题目：找出所有相加之和为n的k个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 难度：Medium
 * 思路：
 */

// @lc code=start
class Solution {
    private boolean[] flag = new boolean[9];

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(result, new ArrayList<>(), 0, k, n, 1);
        return result;
    }

    private void backTrace(List<List<Integer>> result, List<Integer> tempResult, int cur, int k, int targetNum, int curNum) {
        if (cur == k && targetNum == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        if (cur > k || targetNum < 0) {
            return;
        }
        for (int i = curNum;i <= 9;i++) {
            if (!flag[i-1]) {
                flag[i-1] = true;
                tempResult.add(i);
                backTrace(result, tempResult, cur+1, k, targetNum-i, i+1);
                flag[i-1] = false;
                tempResult.remove(tempResult.size()-1);
            }
        }
    }
}
// @lc code=end

