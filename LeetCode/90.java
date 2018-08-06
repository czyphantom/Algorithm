/**
 * 题目：给定一个可能包含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 难度：Medium
 * 思路：回溯
 */

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