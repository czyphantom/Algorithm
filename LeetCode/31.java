/**
 * 题目：给一个int数组，给出比该数组的排列大的下一个排列，不能使用额外数组，如果没有更大的，就按从小到大的顺序排列。
 * 难度：Medium
 * 思路：如果某个数右边的排列是递减排列的，那么下一个排列一定将这些递减排列的反转，再交换该数与右边的一个小于该数的数
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}