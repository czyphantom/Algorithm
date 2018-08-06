/**
* 题目：找出二叉查找树的第k个结点
* 思路：中序遍历的第k个结点就是
*/

public class Solution {
    int index = 0;
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root != null){
            TreeNode node = KthNode(root.left,k);
            if(node != null)
                return node;
            index++;
            if(index == k)
                return root;
            node = KthNode(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}
