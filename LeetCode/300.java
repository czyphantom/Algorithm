/**
 * 题目：最长上升子序列。
 * 难度：Medium
 * 思路：关键是对dp数组的定义，dp数组为长度为i的序列的最末数字的最小值，因此dp数组递增，最后只需要求dp数组的长度即可。
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for (int num : nums) {
            int low = 0,high = maxLength;
            while(low < high) {
                int mid = low + (high-low)/2;
                if (dp[mid] < num) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
            dp[low] = num;
            if (low == maxLength) {
                maxLength++;
            }
        }
        return maxLength;
    }
}