/**
 * 题目：给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 难度：Medium
 * 思路：BFS
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Deque<TreeNode> q = new ArrayDeque<>();
        root.val = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            if (size >= 2) {
                res = Math.max(res, q.peekLast().val - q.peekFirst().val + 1);
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2;
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 1;
                    q.offer(cur.right);
                }
            }
        }
        return res;
    }
}