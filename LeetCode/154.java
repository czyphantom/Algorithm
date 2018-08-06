/**
 * 题目：假设按照升序排序的数组在预先未知的某个点上进行了旋转。请找出其中最小的元素。注意数组中可能存在重复的元素。
 * 难度：Hard
 * 思路：二分
 */

class Solution {
    public int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        int res = nums[0];
        while (end - begin > 1) {
            int mid = (begin+end)/2;
            if (nums[mid] < nums[begin]) {
                res = Math.min(res, nums[end]);
                end = mid;
            } else if (nums[mid] > nums[begin]) {
                res = Math.min(res, nums[begin]);
                begin = mid + 1;
            } else {
                begin++;
            }
        }
        res = Math.min(res, nums[begin]);
        res = Math.min(res, nums[end]);
        return res;
    }
}