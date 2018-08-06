/**
 * 题目：统计所有小于非负整数n的质数的数量。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int countPrimes(int n) {
    int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!used[i - 1]) {
                int temp = i * i;
                while (temp < n) {
                    used[temp - 1] = true;
                    temp += i;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!used[i - 1]) {
                res++;
            }
        }
        return res;
    }
} 