/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 * 题目：给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。给定 n 和 k，返回第 k 个排列。
 * 难度：Hard
 * 思路：数学问题
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
// @lc code=end

