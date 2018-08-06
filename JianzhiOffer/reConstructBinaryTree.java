/**
* 题目：根据先序遍历和中序遍历重建二叉树
* 思路：分治
*/

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    private TreeNode reConstructBinaryTree(int [] pre,int begin1,int end1,int [] in,int begin2,int end2) {
        if(begin1 > end1 || begin2 > end2) {
            return null;
        }
        int root = pre[begin1];
        int loc = begin2;
        while(loc <= end2) {
            if(in[loc] == root) {
                break;
            }
            loc++;
        }
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = reConstructBinaryTree(pre,begin1+1,loc-begin2+begin1,in,begin2,loc-1);
        rootNode.right = reConstructBinaryTree(pre,loc-begin2+begin1+1,end1,in,loc+1,end2);
        return rootNode;
    }
}
