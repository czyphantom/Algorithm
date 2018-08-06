/**
 * 题目：给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 难度：Easy
 * 思路：水题，也可以用摩尔投票
 */

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count=1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]!=nums[i-1]){
                count++;
                if(count==3)
                    return nums[i-1];        
            }
        }
        return nums[nums.length-1];
    }
}