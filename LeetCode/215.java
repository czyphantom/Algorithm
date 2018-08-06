/**
 * 题目：在未排序的数组中找到第k个最大的元素。请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 * 难度：Medium
 * 思路：快速排序的partition
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int partition = quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
        return nums[partition];
    }
    
    private int quickSelect(int[] nums, int begin, int end, int k) {
        int i = begin, j = end, pivot = nums[end];
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, end);

        int m = i - begin + 1;
        if (m == k) {
            return i;
        }    
        else if (m > k) {
            return quickSelect(nums, begin, i - 1, k);
        }
        else {
            return quickSelect(nums, i + 1, end, k - m);
        } 
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}