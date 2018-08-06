/**
 * 题目：一个只有0,1,2的数组进行排序。
 * 难度：Medium
 * 思路：类似快速排序的三向切分
 */

class Solution {
    public void sortColors(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        int i = 0;
        while(i <= end) {
            if(nums[i] == 0) {
                nums[i] = nums[begin];
                nums[begin] = 0;
                begin++;
            }
    
            if(nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
                i--;
            }
            i++;
        }
    }
}