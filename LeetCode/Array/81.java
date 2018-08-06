/**
* 题目大意：一个包含重复数字的已排序的数组进行旋转，给一个数，问是否在这之中。
* 难度：Medium
* 思路：关键在于二分的过程中哪一部分是已经有序的，这里会出现一种特殊情况，就是begin，mid，end三个位置数* 都一样，这种情况，begin++或者end--都可以。
*/

public boolean search(int[] nums, int target) {
    int begin = 0;
    int end = nums.length-1;
    while(begin <= end) {
        int mid = (begin+end)/2;
        if(target == nums[mid])
            return true;
        if(nums[begin] < nums[mid] || nums[mid] > nums[end]) {
            if(target < nums[mid] && target >= nums[begin])
                end = mid - 1;
            else
                begin = mid + 1;
        }
        else if(nums[mid] < nums[end] || nums[mid] < nums[begin]) {
            if(target > nums[mid] && target <= nums[end])
                begin = mid + 1;
            else
                end = mid - 1;
        } else {
            end--;
        }
    }
    return false;
}
