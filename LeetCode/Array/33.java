/** 题目大意：就是在一个可能翻转了的升序数组中，找出一个目标数，找不到返回-1，找到返回索引。
* 难度：Medium
* 思路：主要就是看要查找的区间是否是严格升序的通过比较begin，mid，end三个位置的数的大小可以得begin<=
* mid和mid<=end至少有一个成立，接着每一种情况除了判断目标和中间的大小外还应该判断与begin或者end的大
* 小（因为要在严格递增的区间找）
*/

public int search(int[] nums, int target) {
    int begin= 0;
    int end = nums.length - 1;
    while (begin <= end){
        int mid = (begin + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[begin] <= nums[mid]){
             if (target < nums[mid] && target >= nums[begin])
                end = mid - 1;
             else
                begin = mid + 1;
        }
        if (nums[mid] <= nums[end]){
            if (target > nums[mid] && target <= nums[end])
                begin = mid + 1;
             else
                end = mid - 1;
        }
    }
    return -1;
}
