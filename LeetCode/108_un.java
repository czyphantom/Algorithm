/**
 * 题目：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。本题中，一个高度平衡二叉树是指一个二叉树每个节
 * 点 的左右两个子树的高度差的绝对值不超过1。
 * 难度：Easy
 * 思路：二分
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        return solve(nums, 0, nums.length-1);
    }

    private TreeNode solve(int[] nums,int begin,int end) {
        int mid = (end-begin)/2+begin;
        if(begin > end)
            return null;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums,begin,mid-1);
        node.right = solve(nums,mid+1,end);
        return node;
    }
}