/**
* 题目大意：就是一个升序序列，里面有相同的数，找出目标数的开始位置和结束位置。
* 难度：Medium
* 思路：分为两个部分，一是找到左边的位置，二是找到右边的位置，找这两个位置其实本质相同，以找左边的位置为
* 例，用二分查找到该目标数后，如果前一位存在且不等于目标数，左边的位置就找到了，否则，继续往左边查找。
*/

public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = findLeft(nums,0,nums.length-1,target);
    res[1] = findRigth(nums,0,nums.length-1,target);
    return res;
}

private int findLeft(int[] nums,int begin,int end,int target) {
    int res = -1;
    while(begin <= end) {
        int mid = (begin+end)/2;
        if(target < nums[mid])
            end = mid - 1;
        if(target > nums[mid])
            begin = mid + 1;
        if(nums[mid] == target) {
            if((mid-1 >= begin && nums[mid-1] != target) || mid == begin) {
                res = mid;
                break;
            }
            else
                end = mid - 1;
        }
    }
    return res;
}

private int findRigth(int[] nums,int begin,int end,int target) {
    int res = -1;
    while(begin <= end) {
        int mid = (begin+end)/2;
        if(target < nums[mid])
            end = mid - 1;
        if(target > nums[mid])
            begin = mid + 1;
        if(nums[mid] == target) {
            if((mid+1 <= end && nums[mid+1] != target) || mid == end) {
                res = mid;
                break;
            }
            else
                begin = mid+1;
        }
    }
    return res;
}
