/**
 * 题目：给定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 难度：Medium
 * 思路：因为两个相同的数字其异或结果为0，先对整个数组进行异或，所得结果为两个只出现一次的数字的异或结果，其必不为0，
 * 因此至少有一位为1，设第N位为1，这样把原数组划分为两个子数组，一个第N位为1，一个第N位为0，这样每个子数组都有一个数字只出现一次，再做异或即可。
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length <= 1) {
            return result;
        }
        int len = nums.length, index = 0, sum = 0;
        //计算所有数异或的结果
        for (int i = 0; i < len; i++) {
            sum ^= nums[i];
        }
        //找到sum中第一个不为0的位置
        for (index = 0; index < 32; index++) {
            if ((sum & (1 << index)) != 0)
                break;
        }
        //将数组按照该位置是否为1分成两个部分，分别对这两个部分做异或即可得到结果
        for (int i = 0; i < len; i++) {
            if ((nums[i] & (1 << index)) != 0) {
                result[1] ^= nums[i];
            } else {
                result[0] ^= nums[i];
            }
        }
        return result;
    }
}