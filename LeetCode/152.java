/**
* 题目大意：最大连续子数组乘积
* 难度：Medium
* 思路：动态规划
*/

class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int result = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            max[i] = Math.max(Math.max(nums[i],max[i-1]*nums[i]),min[i-1]*nums[i]);
            min[i] = Math.min(Math.min(nums[i],min[i-1]*nums[i]),max[i-1]*nums[i]);
            if(max[i] > result) {
                result = max[i];
            }
        }
        return result;
    }
}

