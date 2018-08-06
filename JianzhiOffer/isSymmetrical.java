/**
* 题目：判断一棵树是否对称
* 思路：递归判断
*/

public class Solution {
    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;
        return isSymm(pRoot.left,pRoot.right);
    }
    
    private boolean isSymm(TreeNode left,TreeNode right) {
        if(left == null && right == null)
            return true;
        if((left == null && right != null) || (left != null && right == null))
            return false;
        if(left.val != right.val)
            return false;
        return isSymm(left.left,right.right) && isSymm(left.right,right.left);
    }
}