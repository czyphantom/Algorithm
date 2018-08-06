/**
 * 题目：给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construt(nums, 0, nums.length-1);
    }
     
    public TreeNode construt(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int max = nums[left];
        int max_index = left;
        for(int i = left+1;i <= right;i++){
            if(nums[i] > max){
                max=nums[i];
                max_index=i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construt(nums, left, max_index-1);
        root.right = construt(nums, max_index+1, right);
        return root;
    }
}