/** 题目大意:给一个数组，求（i,a[i])和(j,a[j])与x轴围成的最大面积。
* 难度：Medium
* 思路：两个指针，一个从头，一个从尾向中间移动，如果左边的指针所指示的数字比右边的小，左指针往后移一位，
* 反之右指针往前移一位。
*/

public int maxArea(int[] height) {
    int len = height.length;
    int i = 0;
    int j = len-1;
    int max = 0;
    while(i < j) {
        max = Math.max(max,Math.min(height[i],height[j])*(j-i));
        if(height[i] < height[j])
            i++;
        else
            j--;
    }
    return max;
}
