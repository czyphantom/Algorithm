/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 * 题目：格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 * 难度：Medium
 * 思路：回溯或者公式
 */

// @lc code=start
class Solution {

    /**
     * 方法1：回溯
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        helper(result,list,n);
        return result;
    }

    private void helper(List<Integer> result,List<Integer> list,int n){
        if(list.size() == Math.pow(2,n)){
            result.addAll(list);
            return;
        }
        int last = list.get(list.size() - 1);
        for(int i = 0; i < n; i++){
            int off = 1 << i;
            int cur = last ^ off;
            
            if(list.contains(cur)) {
                continue;
            }
            list.add(cur);
            helper(result,list,n);
            if(result.size() > 0) 
                return;
            list.remove(list.size() - 1);
        }
    } 

    /**
     * 方法2：公式法
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ i>>1);
        }
        return result;
    }
}
// @lc code=end

