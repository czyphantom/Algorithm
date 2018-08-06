/**
* 题目大意：一个已排序的数组，删除重复超过两次的数字，返回长度。
* 难度：Medium
* 思路：用两个指针，一个遍历数组记录哪些出现大于2，一个用来改变原数组。
*/

public int removeDuplicates(int[] nums) {
    int count = 1;
    int j = 1;
    if(nums.length < 2) {
        return nums.length;
    }
    for(int i = 1;i < nums.length;i++) {
        if(nums[i] == nums[i-1] && count < 2) {
            count++;
            nums[j++] = nums[i];
        }
        else if(nums[i] == nums[i-1] && count >= 2) {
            count++;
        } else {
            count = 1;
            nums[j++] = nums[i];
        }
    }

    return j;
}
