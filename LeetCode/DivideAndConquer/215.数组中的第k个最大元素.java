/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 * 题目：给定整数数组nums和整数k，请返回数组中第k个最大的元素。
 * 难度：Medium
 * 思路：快排的partition或者优先队列
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        return findKthLargest(nums, 0, nums.length-1, nums.length-k);
    }

    private int findKthLargest(int[] nums, int begin, int end, int k) {
        int pivot = nums[begin];
        int i = begin, j = end;
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        if (i == k) {
            return pivot;
        } else if (i < k) {
            return findKthLargest(nums, i+1, end, k);
        } else {
            return findKthLargest(nums, begin, i-1, k);
        }
    }

    //方法2，堆排序
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        } 
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        } 
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// @lc code=end

