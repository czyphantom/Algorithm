/**
 * 题目：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 难度：Medium
 * 思路：动态规划
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] temp = new int[A.length+1][B.length+1];
        int result = 0;
        for(int i = 0;i < A.length+1;i++) {
            for(int j = 0;j < B.length+1;j++) {
                if(i == 0 || j == 0) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = A[i-1]==B[j-1]?temp[i-1][j-1]+1:0;
                }
                result = Math.max(result, temp[i][j]);
            }
        }

        return result;
    }
}