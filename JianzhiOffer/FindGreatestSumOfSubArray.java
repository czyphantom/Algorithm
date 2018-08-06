/**
* 题目：求最大连续子数组和
* 思路：动态规划
*/

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < array.length;i++) {
            if(sum <= 0)
                sum = array[i];
            else
                sum += array[i];
            if(sum > max)
                max = sum;
        }
        return max;
    }
}
