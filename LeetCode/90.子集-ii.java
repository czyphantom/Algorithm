/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 * 题目：给你一个整数数组nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] num;
    int len;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        len = nums.length;
        num = nums;
        Arrays.sort(num);
        res.add(new ArrayList<>());
        sub(0,new ArrayList<>());
        return res;
    }

    public void sub(int start,List<Integer> ans){
        int flag = 0;
        for( int i = start;i < len;i++){
            if(i > 0 && flag == 1 && num[i] == num[i-1]) {
                continue;
            }
            ans.add(num[i]);
            flag = 1;
            res.add(new ArrayList<Integer>(ans));
            sub(i+1,ans);
            ans.remove(ans.size()-1);
        }
        return ;
    }
}
// @lc code=end

