/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 * 题目：给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你 合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组nums1中。为了应对这种情况，nums1的初始长度为m + n，其中前m个元素表示应合并的元素，后n个元素为0 ，应忽略。nums2的长度为n 。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m+n-1;
        int i = m-1,j = n-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[cur] = nums1[i];
                i--;
            } else {
                nums1[cur] = nums2[j];
                j--;
            }
            cur--;
        }
        while (i >= 0) {
            nums1[cur--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[cur--] = nums2[j--];
        }
    }
}
// @lc code=end

