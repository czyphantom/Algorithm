/**
* 题目：求树的最大深度
* 思路：简单的递归
*/

public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        else
            return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
