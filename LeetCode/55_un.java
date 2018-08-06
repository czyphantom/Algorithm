/** 
 * 题目：给一个非负的一维数组，每个元素代表能跨越的最大步数，问是否能从第一个位置到达最后一个位置。
 * 难度：Medium
 * 思路：维护一个count，表示该位置能走的最大步数，每次到下一个位置，count-1，如果小于0，返回false，否则count更新为与该位置的值比较后的较大者。
 **/

class Solution {
    public boolean canJump(int[] nums) {
        int count = nums[0];
        if(nums.length == 1) {
            return true;
        }
        for(int i = 1;i < nums.length;i++) {
            count--;
            if(count < 0) {
                return false;
            }
            count = Math.max(count,nums[i]);
        }
        return true;
    }
}