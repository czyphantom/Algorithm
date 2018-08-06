/**
* 题目：将一棵二叉排序树转换为排序的双向链表，不能新建结点
* 思路：中序遍历一棵二叉树可以得到有序序列，考虑递归处理，要注意一些细节。
*/

public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //转化后返回的是左子树的最左结点（如果存在左子树）
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode tmp = left;
        //得到左子树的最大（即最右结点，如果存在）
        while(tmp != null && tmp.right != null)
            tmp = tmp.right;
        //建立前后关系
        if(left != null) {
            tmp.right = pRootOfTree;
            pRootOfTree.left = tmp;
        }
        //得到右子树的最左结点，建立前后关系
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left == null ? pRootOfTree:left;
    }
}
