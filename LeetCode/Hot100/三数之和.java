/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 * 题目：给你一个整数数组nums，判断是否存在三元组[nums[i],nums[j],nums[k]]满足i != j、i != k且j != k，同时还满足nums[i] + nums[j] + nums[k] == 0。请你返回所有和为0且不重复的三元组。
 * 难度：Medium
 * 思路：一个比较直观的思路是对数组排序之后，固定两个元素，二分搜索第三个元素，复杂度O(n^2logn)，更简单的应该是固定2个元素，剩下一个元素用双指针遍历
 */

// @lc code=start
class Solution {
      public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0;first < nums.length-2;first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int third = nums.length-1;
            for (int second = first+1;second < nums.length-1;second++) {
                if (second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > -nums[first]) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == -nums[first]) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[first]);
                    triple.add(nums[second]);
                    triple.add(nums[third]);
                    result.add(triple);
                } 
            }
        }
        return result;
    }
}
// @lc code=end

