/**
 * 题目：数组A是[0,1, ...,N-1]的一种排列，N是数组A的长度。全局倒置指的是i,j 满足0<=i<j<N并且A[i]>A[j]，
 * 局部倒置指的是i满足0<=i<N并且A[i]>A[i+1] 。当数组A中全局倒置的数量等于局部倒置的数量时，返回true 。
 * 难度：Medium
 * 思路：如果A[i] > i，那么全局倒置的数目必然有A[i]-i个。
 */

class Solution {
    public boolean isIdealPermutation(int[] A) {
        int globalCount = 0,regionalCount = 0;
        for(int i = 0;i < A.length-1;i++) {
            if(A[i] > A[i+1]) {
                regionalCount++;
            }
            if(A[i] > i) {
                globalCount += A[i]-i;
            }
            if(A[i] == i) {
                int j = i;
                while(j < A.length) {
                    if(A[j] < A[i]) {
                        globalCount++;
                    }
                    j++;
                }
            }
        }
        return globalCount == regionalCount;
    }
}