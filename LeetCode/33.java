/** 
 * 题目：在一个可能翻转了的升序数组中，找出一个目标数，找不到返回-1，找到返回索引。
 * 难度：Medium
 * 思路：二分变形，因为二分只能在有序数组中找，通过判断begin，mid，end三处的大小可以得到哪一部分是有序的
*/

class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end){
            int mid = (begin + end) / 2;
            if (nums[mid] == target)
                return mid;
            //左半边有序
            if (nums[begin] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[begin]) {
                    end = mid - 1;
                 } else {
                    begin = mid + 1;
                 }
            }
            //右半边有序
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}