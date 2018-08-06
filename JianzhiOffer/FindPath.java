/**
* 题目：找出一棵树中路径和等于给定树的所有路径
* 思路：回溯
*/

public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) 
            return res;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return res;
    }
}
