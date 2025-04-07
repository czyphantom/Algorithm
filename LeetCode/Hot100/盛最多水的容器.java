/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 * 题目：给定一个长度为n的整数数组height。有n条垂线，第i条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 难度：Medium
 * 思路：分析一下可知两个端点如果左端点小于右端点，那么最大值出现的左端点绝对不会是在该左端点，同理可得右端点的逻辑，使用双指针按照前面所述的逻辑移动即可
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0,j = height.length-1, maxArea = 0;
        while (i < j) {
            int cur = Math.min(height[i],height[j]) * (j-i);
            maxArea = Math.max(cur, maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
// @lc code=end

