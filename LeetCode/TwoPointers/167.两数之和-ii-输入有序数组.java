/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 * 题目：给你一个下标从1开始的整数数组numbers ，该数组已按非递减顺序排列，请你从数组中找出满足相加之和等于目标数target的两个数。如果设这两个数分别是numbers[index1]和numbers[index2]，则1 <= index1 < index2 <= numbers.length。
 * 以长度为2的整数数组[index1, index2]的形式返回这两个整数的下标index1和index2。
 * 你可以假设每个输入只对应唯一的答案 ，而且你不可以重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 难度：Medium
 * 思路：双指针
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int begin = 0, end = numbers.length-1;
        while (begin < end) {
            if (numbers[begin] + numbers[end] == target) {
                result[0] = begin+1;
                result[1] = end+1;
                return result;
            } else if (numbers[begin] + numbers[end] < target) {
                begin++;
            } else {
                end--;
            }
        }
        return result;
    }
}
// @lc code=end

