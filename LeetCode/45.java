/**
 * 题目：给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 难度：Hard
 * 思路：贪心
 */

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        int len = nums.length;
        int result = 0;
        int i = 0;
        while (i < len) {
            int limit = i + nums[i];
            if (limit >= len-1) {
                return result + 1;
            }
            int j = i+1;
            int max = limit;
            int index = limit;
            while (j <= limit) {
                if (j+nums[j] > max) {
                    max = j+nums[j];
                    index = j;
                }
                j++;
            }
            i = index;
            result++;
        }
        return result;
    }
}