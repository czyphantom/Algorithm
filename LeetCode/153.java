/**
* 题目：求旋转数组的最小值（不含重复元素）
* 难度：Medium
* 思路：二分
*/

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
        }
        return nums[r];
    }
}