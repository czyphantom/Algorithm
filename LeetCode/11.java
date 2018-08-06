/** 
* 题目:给一个数组，求（i,a[i])和(j,a[j])与x轴围成的最大面积。
* 难度：Medium
* 思路：双指针法
*/

class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
