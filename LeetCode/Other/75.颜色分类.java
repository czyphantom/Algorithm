/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 * 题目：给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数0、 1和2分别表示红色、白色和蓝色。
 * 难度：Medium
 * 思路：快排中的三向切分
 */

// @lc code=start
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
// @lc code=end

