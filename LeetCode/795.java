/**
 * 题目：给定一个元素都是正整数的数组A，正整数L以及R(L<=R)。求连续、非空且其中最大元素满足大于等于L小于等于R的子数
 * 组个数。
 * 难度：Medium
 * 思路：用left和right分别标识数组边界
 */

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length;
        int ans = 0;
        int left = -1;
        int right = -1;
        for(int i = 0;i < len;i++) {
            if(A[i] > R) {
                left = i;
                right = i;
            }
            if (A[i] >= L) {
                right = i;
            }
            ans += right-left;
        }
        return ans;
    }
}