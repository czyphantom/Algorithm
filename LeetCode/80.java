/**
* 题目：一个已排序的数组，删除重复超过两次的数字，返回长度。
* 难度：Medium
* 思路：双指针
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int j = 1;
        if(nums.length < 2) {
            return nums.length;
        }
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] == nums[i-1] && count < 2) {
                count++;
                nums[j++] = nums[i];
            }
            else if(nums[i] == nums[i-1] && count >= 2) {
                count++;
            } else {
                count = 1;
                nums[j++] = nums[i];
            }
        }
    
        return j;
    }
}