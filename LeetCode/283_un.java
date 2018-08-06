/**
 * 题目:给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public void moveZeroes(int[] nums) {
      if(nums.length <= 1) {
          return;  
      }
        int first = 0;  
        int sec = 0;  
        while (sec < nums.length) {  
            while(first < nums.length && nums[first] != 0) {  
                first++;  
            }  
            if(first == nums.length) {
                return; 
            } 
            sec = first+1;  
            while (sec < nums.length && nums[sec] == 0){  
                sec++;  
            }  
            if(sec == nums.length) {
                return;
            }  
            swap(nums, first, sec);  
        }  
    }  
    public void swap(int[] nums, int i, int j) {  
        int temp = nums[i];  
        nums[i] = nums[j];  
        nums[j] = temp;  
    }  
}  