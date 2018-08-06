/**
* 题目大意：求一个数组中的峰值，峰值指的是大于左右两边的数，认为-1和n位置为负无穷
* 难度：Medium
* 思路：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素，
* 如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素,begin和end相等为止
*/
public int findPeakElement(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                begin = mid + 1;
        }
        return begin;
}
