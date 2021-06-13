/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 * 题目：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 难度：Medium
 * 思路：和第15题类似
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++) {
            int target2 = target-nums[i];
            int begin = i+1,end = nums.length-1;
            while (begin < end) {
                if (nums[begin] + nums[end] > target2) {
                    if (nums[begin]+nums[end]-target2 < closet) {
                        result = nums[i]+nums[begin]+nums[end];
                        closet = nums[begin]+nums[end]-target2;
                    }
                    end--;
                } else if (nums[begin] + nums[end] < target2) {
                    if (target2-nums[begin]-nums[end] < closet) {
                        result = nums[i]+nums[begin]+nums[end];
                        closet = target2-nums[begin]-nums[end];
                    }
                    begin++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
// @lc code=end

