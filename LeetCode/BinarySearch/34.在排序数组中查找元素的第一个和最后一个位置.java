/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 题目：给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 难度：Medium
 * 思路：二分
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums,0,nums.length-1,target);
        res[1] = findRigth(nums,0,nums.length-1,target);
        return res;
    }
    
    private int findLeft(int[] nums,int begin,int end,int target) {
        int res = -1;
        while(begin <= end) {
            int mid = (begin+end)/2;
            if(target < nums[mid])
                end = mid - 1;
            if(target > nums[mid])
                begin = mid + 1;
            if(nums[mid] == target) {
                if((mid-1 >= begin && nums[mid-1] != target) || mid == begin) {
                    res = mid;
                    break;
                } else {
                    end = mid - 1;
                }     
            }
        }
        return res;
    }
    
    private int findRigth(int[] nums,int begin,int end,int target) {
        int res = -1;
        while(begin <= end) {
            int mid = (begin+end)/2;
            if(target < nums[mid])
                end = mid - 1;
            if(target > nums[mid])
                begin = mid + 1;
            if(nums[mid] == target) {
                if((mid+1 <= end && nums[mid+1] != target) || mid == end) {
                    res = mid;
                    break;
                } else {
                    begin = mid+1;
                }
            }
        }
        return res;
    }
}
// @lc code=end

