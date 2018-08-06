/**
 * 题目：给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值index1和
 * index2，其中index1必须小于index2。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        int sum;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[]{i+1, j+1};
            else if (sum < target)
                i++;
            else
                j--;
        }
        
        return null;
    }
}
