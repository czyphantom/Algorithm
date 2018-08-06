/**
 * 题目：给定两个有序整数数组nums1和nums2，将nums2合并到nums1中，使得num1成为一个有序数组。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
     int j = n - 1;
     int k = m + n - 1;
     while (i >=0 && j >= 0) {
         if (nums1[i] > nums2[j])
             nums1[k--] = nums1[i--];
        else
             nums1[k--] = nums2[j--];
     }
     while (j >= 0)
         nums1[k--] = nums2[j--];
    }
}
