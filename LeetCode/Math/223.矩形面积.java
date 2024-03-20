/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 * 题目：给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 * 难度：Medium
 * 思路：重叠部分的面积为x轴和y轴的中间值，另外要考虑不重叠的情况
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int[] x = new int[]{ax1,ax2,bx1,bx2};
        int[] y = new int[]{ay1,ay2,by1,by2};
        Arrays.sort(x);
        Arrays.sort(y);
        boolean noReat = ax1 > bx2 || ax2 < bx1 || ay1 > by2 || ay2 < by1;
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - (noReat ? 0 : (x[2]-x[1])*(y[2]-y[1]));
    }
}
// @lc code=end

