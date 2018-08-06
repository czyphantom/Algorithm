/**
 * 题目：给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 难度：Hard
 * 思路：未出现的正整数一定是1-n中的一个,将数字交换到正确的位置即可
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == i+1) {
                i++;
            } else {
                if (nums[i] >= 1 && nums[i] <= len) {
                    int index = nums[i] - 1;
                    if (nums[index] == index + 1) {
                        i++;
                    } else {
                        swap(nums, i, index);
                    }
                } else {
                    i++;
                }
            }
        }
        for (int t = 0;t < len;t++) {
            if (nums[t] != t+1) {
                return t+1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}