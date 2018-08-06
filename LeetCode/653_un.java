/**
 * 题目：给定一个二叉搜索树和一个目标结果，如果BST中存在两个元素且它们的和等于给定的目标结果，则返回true。
 * 难度：Easy
 * 思路：中序遍历得到有序序列
 */

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}