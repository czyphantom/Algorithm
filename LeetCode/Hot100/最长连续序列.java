/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 * 题目：给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 难度：Medium
 * 思路：枚举序列时，只需要避免之前枚举过的值即可，首先用set存储，遍历每个值时，如果存在当前值-1，则不枚举，否则从该值开始往上逐个枚举即可
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                int curLength = 1;
                int curNum = num;
                while (numSet.contains(curNum+1)) {
                    curLength++;
                    curNum++;
                }
                result = Math.max(curLength, result);
            }
        }
        return result;
    }
}
// @lc code=end

