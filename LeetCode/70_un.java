/**
 * 题目：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int x = 1,y = 1,sum = 0;
        while (n > 1) {
            sum = x + y;
            x = y;
            y = sum;
            n--;
        }
        return sum;
    }
}