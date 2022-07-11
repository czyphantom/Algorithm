/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 * 题目：给定一个非负整数numRows，生成「杨辉三角」的前numRows行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < numRows;i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0;j <= i;j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
            }
            result.add(cur);
        }
        return result;
    }
}
// @lc code=end

