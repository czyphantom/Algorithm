/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 * 题目：给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        while (i < nums.length) {
            int j = i+1;
            while (j < nums.length && nums[j] == nums[j-1]+1) {
                j++;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(nums[i]);
            if (j-1 > i) {
                builder.append("->");
                builder.append(nums[j-1]);
            }
            i = j;
            result.add(builder.toString());
        }
        return result;
    }
}
// @lc code=end

