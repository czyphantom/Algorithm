/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 * 题目：给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0;i <= rowIndex;i++) {  
            result.add(i, 1);  
            for(int j = i-1;j > 0;j--) {  
                result.set(j, result.get(j) + result.get(j-1));  
            }  
        }  
        return result;  
    }
}
// @lc code=end

