/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 * 题目：给定整数n，返回所有小于非负整数n的质数的数量。
 * 难度：Medium
 * 思路：埃氏筛法
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int result = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                result += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

