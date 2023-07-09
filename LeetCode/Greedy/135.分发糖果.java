/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 * 题目：n个孩子站成一排。给你一个整数数组ratings表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到1个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的最少糖果数目 。
 * 难度：Hard
 * 思路：右边的比左边的大，那么分到的糖果就要比左边的多一个，否则的话就给1个，注意从前往后过一遍，从后往前也过一遍
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果，否则给1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                nums[i] = nums[i-1] + 1;        
            } else {
                nums[i] = 1;
            }
        }
        //在倒序遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for (int i = ratings.length-2 ; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && nums[i] <= nums[i+1]) {
                nums[i] = nums[i+1]+1;
            }
        }
        int count = 0;
        for (int i : nums) {
            count +=i;
        }
        return count;
    }
}
// @lc code=end

