/**
 * 题目：给定范围[m, n]，其中0<=m<=n<=2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 难度：Medium
 * 思路：找规律，n&(n-1)去掉最后一个非0，以此类推。
 */

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return n << i;
    }
}