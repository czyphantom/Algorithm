/**
 * 题目：给定一个大小为n的数组，找到其中的众数。众数是指在数组中出现次数大于⌊n/2⌋的元素。你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 难度：Easy
 * 思路：摩尔投票算法
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}