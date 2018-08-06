/**
* 题目：判断一棵树是否为二叉平衡树
* 思路：在求树深度的时候顺便判断是否平衡
*/

public class Solution {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    
    private int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(Math.abs(getDepth(root.left)-getDepth(root.right)) > 1)
            isBalanced = false;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
