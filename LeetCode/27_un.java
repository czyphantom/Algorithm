/**
 * 题目：给定一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，返回移除后数组的新长度。不要使用额
 * 外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。元素的顺序可以改变。你不需要考虑数组中超
 * 出新长度后面的元素。
 * 难度：Easy
 * 思路：和26类似
 */

class Solution {
    public int removeElement(int[] nums, int val) {
          int length = nums.length;
        int i = 0;
        int j = 0;
        while(i < length) {
            if(nums[i] != val)
                nums[j++] = nums[i];
            i++;
        }
        return j;
    }
}