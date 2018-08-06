/**
 * 题目：实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next()将返回二叉搜索树中的下一个最小的数。
 * 注意: next()和hasNext()操作的时间复杂度是O(1)，并使用O(h)内存，其中h是树的高度。
 * 难度：Medium
 * 思路：中序遍历
 */

public class BSTIterator {
    Stack<TreeNode> stack = null;
    TreeNode current = null;

    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode t = stack.pop();
        current = t.right;
        return t.val;
    }
}