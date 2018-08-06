/**
* 题目：判断树b是否为树a的子结构
* 思路：如果树b中结点与a中结点相等，递归判断是否子结构也相等，如果不相等，则本次判断不成立，递归判断a的
* 左子树和右子树是否与b相等
*/

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2.val)
                res = isSub(root1,root2);
            if(!res)
                res = HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }
        return res;
    }
    
    private boolean isSub(TreeNode root1,TreeNode root2) {
        if(root1 == null && root2 != null)
            return false;
        if(root2 == null)
            return true;
        if(root1.val != root2.val)
            return false;
        return isSub(root1.left,root2.left) && isSub(root1.right,root2.right);
    }
}
