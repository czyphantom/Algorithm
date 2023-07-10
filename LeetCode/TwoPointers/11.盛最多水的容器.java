/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 * 给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i, ai)。在坐标内画n条垂直线，垂直线i的两个端点分别为(i, ai)和(i, 0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 难度：Medium
 * 思路：双指针
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length-1,max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right])* (right-left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
// @lc code=end

